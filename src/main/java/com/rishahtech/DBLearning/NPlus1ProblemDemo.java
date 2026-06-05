package com.rishahtech.DBLearning;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

/**
 * N+1 Problem Demo in JPA/Hibernate
 *
 * WHAT IS THE N+1 PROBLEM?
 * ========================
 * The N+1 problem occurs when:
 * 1. You execute 1 query to fetch N parent entities
 * 2. Then for each of the N entities, you execute 1 additional query to fetch its related entities
 * 3. Total: 1 + N queries instead of just 1 (or 2 with proper fetching)
 *
 * EXAMPLE SCENARIO:
 * ================
 * - You have Department (1) and Employee (N) entities with a One-to-Many relationship
 * - You query all departments: SELECT * FROM department (1 query)
 * - Then for each department, you query its employees: SELECT * FROM employee WHERE department_id = ? (N queries)
 * - Total: 1 + N queries
 *
 * WHY IT HAPPENS:
 * ==============
 * - Default lazy loading in JPA causes related entities to be loaded only when accessed
 * - When you iterate through parent entities and access their collections, Hibernate triggers
 *   additional SELECT statements for each parent. 
 *
 * SOLUTIONS:
 * =========
 * 1. JOIN FETCH (JPQL) - Fetch related entities in the initial query
 * 2. @EntityGraph - Define fetch plan declaratively
 * 3. @BatchSize - Load multiple collections in batches
 * 4. EAGER fetching (not recommended - can cause other issues)
 */

// ==================== ENTITY CLASSES ====================

@Entity
@Table(name = "departments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // LAZY loading by default for OneToMany - this causes N+1 problem
    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    private List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee employee) {
        employees.add(employee);
        employee.setDepartment(this);
    }
}

@Entity
@Table(name = "employees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

}

// ==================== REPOSITORY ====================

class DepartmentRepository {
    private EntityManager em;

    public DepartmentRepository(EntityManager em) {
        this.em = em;
    }

    /**
     * PROBLEMATIC: This causes N+1 problem
     * SQL Queries executed:
     * 1. SELECT * FROM department (1 query)
     * 2. For each department: SELECT * FROM employee WHERE department_id = ? (N queries)
     * Total: 1 + N queries
     */
    public List<Department> findAllWithNPlus1Problem() {
        TypedQuery<Department> query = em.createQuery(
            "SELECT d FROM Department d", Department.class
        );
        return query.getResultList();
    }

    /**
     * SOLUTION 1: JOIN FETCH
     * SQL Query executed:
     * 1. SELECT DISTINCT d.*, e.* FROM department d LEFT JOIN employee e ON d.id = e.department_id
     * Total: 1 query
     */
    public List<Department> findAllWithJoinFetch() {
        TypedQuery<Department> query = em.createQuery(
            "SELECT DISTINCT d FROM Department d " +
            "LEFT JOIN FETCH d.employees", Department.class
        );
        return query.getResultList();
    }

    /**
     * SOLUTION 2: Using EntityGraph
     * Declaratively defines which associations to fetch
     */
    public List<Department> findAllWithEntityGraph() {
        EntityGraph<Department> graph = em.createEntityGraph(Department.class);
        graph.addAttributeNodes("employees");

        TypedQuery<Department> query = em.createQuery(
            "SELECT d FROM Department d", Department.class
        );
        query.setHint("jakarta.persistence.loadgraph", graph);
        return query.getResultList();
    }
}

// ==================== DEMO CLASS ====================

public class NPlus1ProblemDemo {

    public static void main(String[] args) {
        System.out.println("=== N+1 PROBLEM DEMO - CONCEPTUAL EXPLANATION ===\n");

        System.out.println("SCENARIO: Department (1) <-> Employee (N) relationship");
        System.out.println("We have 3 departments and 5 employees total\n");

        System.out.println("=== PROBLEM: N+1 QUERIES ===");
        System.out.println("When you execute: SELECT d FROM Department d");
        System.out.println("\nHibernate executes:");
        System.out.println("  1. SELECT * FROM department                    -- Fetches 3 departments");
        System.out.println("  2. SELECT * FROM employee WHERE dept_id = 1    -- Fetches IT employees");
        System.out.println("  3. SELECT * FROM employee WHERE dept_id = 2    -- Fetches HR employees");
        System.out.println("  4. SELECT * FROM employee WHERE dept_id = 3    -- Fetches Finance employees");
        System.out.println("\nTotal: 4 queries (1 + 3) instead of 1 query");
        System.out.println("Performance impact: Significant with large datasets\n");

        System.out.println("=== SOLUTION: JOIN FETCH ===");
        System.out.println("When you execute: SELECT DISTINCT d FROM Department d LEFT JOIN FETCH d.employees");
        System.out.println("\nHibernate executes:");
        System.out.println("  1. SELECT DISTINCT d.*, e.* FROM department d");
        System.out.println("     LEFT JOIN employee e ON d.id = e.department_id");
        System.out.println("\nTotal: 1 query with all data loaded in single round-trip");
        System.out.println("Performance impact: Optimal\n");

        System.out.println("=== OTHER SOLUTIONS ===");
        System.out.println("1. @EntityGraph - Declarative fetch plan definition");
        System.out.println("2. @BatchSize(size = N) - Load collections in batches");
        System.out.println("3. @NamedEntityGraph - Reusable fetch plans");
        System.out.println("\n=== KEY TAKEAWAY ===");
        System.out.println("Always use JOIN FETCH or EntityGraph when you need to access");
        System.out.println("collections immediately after querying parent entities.");
    }
}

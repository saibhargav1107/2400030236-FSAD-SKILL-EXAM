# Upgrade Plan: skill (20260314095949)

- **Generated**: 2026-03-14 09:59:49
- **HEAD Branch**: main
- **HEAD Commit ID**: c372463d4a0072248c066c73dfe0cfe81c951803

## Available Tools

**JDKs**
- JDK 24.0.2: C:\Program Files\Java\jdk-24\bin (available for baseline checks)
- JDK 21: **<TO_BE_INSTALLED>** (required by Step 1 for final Java 21 runtime target)

**Build Tools**
- Maven Wrapper (`mvnw`/`mvnw.cmd`): not found in project root
- Maven 3.9.11: **<TO_BE_INSTALLED>** (required by Step 1 for reproducible build commands)

## Guidelines

- Upgrade Java runtime to LTS Java 21 using upgrade tooling.
- Keep changes minimal and focused on Java runtime/compiler target alignment.

## Options

- Working branch: appmod/java-upgrade-20260314095949
- Run tests before and after the upgrade: true

## Upgrade Goals

- Upgrade Java from 17 to 21.

### Technology Stack

| Technology/Dependency | Current | Min Compatible | Why Incompatible |
| --------------------- | ------- | -------------- | ---------------- |
| Java | 17 | 21 | User requested Java 21 LTS runtime |
| Maven Compiler Properties | source/target=17 | source/target=21 | Build is pinned to Java 17 |
| Hibernate Core | 5.6.15.Final | 5.6.15.Final | Compatible with Java 21 for this project scope |
| MySQL Connector/J | 8.0.33 | 8.0.33 | Compatible for this project scope |
| javax.persistence-api | 2.2 | 2.2 | No direct Java 21 blocker for compilation |
| JUnit | 3.8.1 | 3.8.1 | Legacy but compiles for current tests |

### Derived Upgrades

- Update `maven.compiler.source` from `17` to `21` (required to compile with Java 21 language level).
- Update `maven.compiler.target` from `17` to `21` (required to produce Java 21 bytecode target).
- Ensure local build toolchain includes Java 21 and Maven before verification.

## Upgrade Steps

- **Step 1: Setup Environment**
  - **Rationale**: Java 21 and Maven are required and currently missing from detected tool inventory.
  - **Changes to Make**:
    - [ ] Install JDK 21 using upgrade tooling
    - [ ] Install Maven 3.9.11 using upgrade tooling
    - [ ] Verify installed paths are available for build execution
  - **Verification**:
    - Command: `#list_jdks` and `#list_mavens`
    - Expected: JDK 21 and Maven are listed with valid local paths

- **Step 2: Setup Baseline**
  - **Rationale**: Capture pre-upgrade compile/test status for comparison.
  - **Changes to Make**:
    - [ ] Run baseline compile including tests with current project config
    - [ ] Run baseline test suite and record pass/fail
  - **Verification**:
    - Command: `mvn clean test-compile -q` and `mvn clean test -q`
    - JDK: C:\Program Files\Java\jdk-24\bin (current available JDK)
    - Expected: Baseline compile/test result documented in progress

- **Step 3: Upgrade Java Compiler Target to 21**
  - **Rationale**: Core change required to meet Java 21 upgrade goal.
  - **Changes to Make**:
    - [ ] Update `pom.xml` compiler properties from 17 → 21
    - [ ] Keep dependencies unchanged unless compile errors require minimal compatibility fixes
    - [ ] Resolve compile issues if introduced
  - **Verification**:
    - Command: `mvn clean test-compile -q`
    - JDK: <installed JDK 21 path>
    - Expected: Compilation success for main and test code

- **Step 4: Final Validation**
  - **Rationale**: Confirm all goals met with clean build and full tests.
  - **Changes to Make**:
    - [ ] Verify `pom.xml` reflects Java 21 target values
    - [ ] Run full clean test cycle on Java 21
    - [ ] Fix any remaining test failures until full pass
  - **Verification**:
    - Command: `mvn clean test -q`
    - JDK: <installed JDK 21 path>
    - Expected: Compilation success and 100% tests pass

## Key Challenges

- **Legacy dependency matrix with newer JDK**
  - **Challenge**: Older libraries may show warnings or strictness differences under Java 21.
  - **Strategy**: Keep dependency changes minimal and only adjust if compile/tests fail.

- **No Maven wrapper in repository**
  - **Challenge**: Build reproducibility depends on local Maven installation.
  - **Strategy**: Install and pin Maven 3.9.11 for upgrade execution consistency.

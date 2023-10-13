# UnitTestBot Spring: demo

This repository illustrates the [UnitTestBot](https://github.com/UnitTestBot/UTBotJava) main features related to generating tests for Spring-based code.

Here you can find the source code examples with comments as well as the resulting UnitTestBot-generated tests.

For comparison, we also
[provide tests](https://github.com/UnitTestBot/UnitTestBot-Spring-demo/tree/main/src/test/java/diffblue) generated 
with [Diffblue Cover](https://www.diffblue.com/products/), the UnitTestBot major competitor.

## How UnitTestBot generates tests for non-Spring projects

| Source                               | Settings                           | Tests                    |
|--------------------------------------|------------------------------------|--------------------------|
| `IntComparator.max`                  | Symbolic execution<br/>Unit tests  | `IntComparatorTests`     |
| `ArrayListVerifier.checkIfNotEmpty`  | Symbolic execution<br/>Unit tests  | `ArrayListVerifierTests` |
| `CustomByteReader.readBytes`         | Symbolic execution<br/>Unit tests  | `CustomByteReaderTests`  |

## How UnitTestBot generates Spring-specific tests

| Source                                | Settings                                                                | Tests                                     |
|---------------------------------------|-------------------------------------------------------------------------|-------------------------------------------|
| `OrderService.isMajorityExpensive`    | Symbolic execution<br/>Unit tests                                       | `OrderServiceUnitTests`                   |
| `OrderService.isNotEmpty`             | Symbolic execution<br/>Unit tests                                       | `OrderServiceUselessUnitTests`            |
| `OrderService.isNotEmpty`             | _Fuzzing_<br/>_Integration tests_<br/>**Spring Boot autoconfiguration** | `OrderServiceIntegrationTests`            |
| `CalculatorService.calcSquareSum`     | Symbolic execution<br/>Unit tests                                       | `CalculatorServiceNoConfigurationTests`   |
| `CalculatorService.calcSquareSum`     | Symbolic execution<br/>Unit tests<br/>**Spring Boot autoconfiguration** | `CalculatorServiceWithConfigurationTests` |
| `OrderController.isMajorityExpensive` | _Fuzzing_<br/>_Integration tests_<br/>**Spring Boot autoconfiguration** | `OrderControllerTests`                    |

## How UnitTestBot resets a state between tests

| Source            | Settings                           | Tests                    |
|-------------------|------------------------------------|--------------------------|
| `MutableService`  | Symbolic execution<br/>Unit tests  | `MutableServiceTests`    |


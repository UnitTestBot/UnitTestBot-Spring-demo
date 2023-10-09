# UnitTestBot Spring: demo

This is a set of examples demonstrating basic flow of UnitTestBot. 

The settings of UnitTestBot we use to generate tests are shown in brackets: 
    - SE (symbolic engine) or F (fuzzer) <br>
   - Unit tests (U) or integration tests (I) <br>
    - Spring Boot autoconfiguration is used (+) <br>

First examples show the features of UnitTestBot on projects without Spring:

1) `IntComparator.max` (SE, U) -> `IntComparatorTests`
2) `ArrayListVerifier.checkIfNotEmpty` (SE, U) -> `ArrayListVerifierTests`
3) `CustomByteReader.readBytes` (SE, U) -> `CustomByteReaderTests`

Next examples show how UnitTestBot takes into account the Spring specific:

4) `OrderService.isMajorityExpensive` (SE, U) -> `OrderServiceUnitTests`

5) `OrderService.isNotEmpty` (SE, U) -> `OrderServiceUselessUnitTests`
   `OrderService.isNotEmpty` (F, I, +) -> `OrderServiceIntegrationTests`

6) `CalculatorService.calcSquareSum` (SE, U) -> `CalculatorServiceNoConfigurationTests`
   `CalculatorService.calcSquareSum` (SE, U, +) -> `CalculatorServiceWithConfigurationTests`

7) `OrderController.isMajorityExpensive` (F, I, +) -> `OrderControllerTests`


All examples are provided with some comments clarifying what happens.

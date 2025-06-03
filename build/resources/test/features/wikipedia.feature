
Feature: Flujos en Wikipediapp

  Scenario:  Agregar idioma en home
    Given Estoy en el onboarding de wiki
    When agregar el idioma "Español"
    Then  visualizo la configuración del idioma nuevo
@nuevo
  Scenario:  Omitir Onboarding y realizar busqueda
    Given Estoy en el home de wiki
    When realizar una busqueda con "Colombia"
    And selecciono el primer resultado
    Then  visualizo el resultado
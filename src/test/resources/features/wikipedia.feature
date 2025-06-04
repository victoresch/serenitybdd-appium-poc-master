
Feature: Flujos en Wikipediapp

  Scenario:  Agregar idioma en onboarding
    Given Estoy en el onboarding de wiki
    When agrego el idioma "Español"
    Then  visualizo la configuración del idioma nuevo

  Scenario:  Omitir Onboarding y realizar busqueda
    Given Estoy en el home de wiki
    When realizar una busqueda con "Colombia"
    And selecciono el primer resultado
    Then  visualizo el resultado "Colombia"

  Scenario:  Omitir Onboarding y configurar el idioma
    Given Estoy en el home de wiki
    When ingreso a configuracion de "idioma"
    And agrego el idioma "Español"
    Then  visualizo la nueva configuración
  @nuevo
  Scenario:  Personalizar feed
    Given Estoy en el home de wiki
    When ingreso a configuracion de "feed"
    And personalizo el feed
    Then  visualizo la nueva configuración del feed
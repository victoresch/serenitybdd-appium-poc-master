#Feature: Log in

 # Scenario: Try to log in with not valid credentials
 #Given John Wick wants to create a new post

Feature: Flujos en Wikipediapp

  Scenario:  Agregar idioma en home
    Given Estoy en el home de wiki
    When agregar el idioma "Español"
    Then  visualizo la configuración del idioma nuevo


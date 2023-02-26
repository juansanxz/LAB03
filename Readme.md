# Laboratorio 3 
## Integrantes
* Santiago Arevalo Rojas
* Juan Felipe Sánchez Pérez

## CLASES DE EQUIVALENCIA
### Crear un proyecto con Maven

Crear el proyecto maven, basado en el arquetipo especificado:
<img src="/img/1.png" width="80%" height="80%"/>

### Actualizar y crear dependencias en el proyecto

Entrando al repositorio central de maven y buscando el artifact más nuevo de JUnit, se encuentra el siguiente:
<img src="/img/2.png" width="80%" height="80%"/>

Seleccionar en la parte de Maven para copiar las dependencias:
<img src="/img/3.png" width="80%" height="80%"/>

Modificar el pom.xml:  
<img src="/img/4.png" width="80%" height="80%"/>

### Compilar y ejecutar

Compilar el proyecto:  
<img src="/img/5.png" width="80%" height="80%"/>

Usando el comando mvn test, se evidencia que se ejecuta la clase AppTest con éxito:  
<img src="/img/6.png" width="80%" height="80%"/>

## Ejercicio registraduría
### Hacer el esqueleto de la aplicación

En el proyecto se evidencia la creación de las clases especificadas y dadas.

## Ejecutar las pruebas
Haciendo la prueba:

```
@Test    public void validateRegistryResult() {
    Person person = new Person();
    RegisterResult result = registry.registerVoter(person);
    assertEquals(RegisterResult.VALID, result);
    }
```
Y el mínimo código para que pase:

```
/**     
    * Validates if a person is allowed to vote     
     * @param p person who we are validating    
     * @return a RegisterResult constant according to the validations     
     */    
     public RegisterResult registerVoter(Person p) {
        return RegisterResult.VALID;
    }
```


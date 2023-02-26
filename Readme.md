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
Ejecutando pruebas en mvn:  
<img src="/img/7.png" width="80%" height="80%"/>

### Finalizar el ejercicio

Realizando los casos de equivalencia (uno por cada condición), y por lo tanto, completando la clase RegistryTest.java:
```
    @Test    
    public void should_NotAllowToVote_When_PersonIsAlreadyIn () {
        //arrange        
        Person person = new Person("Ivan", 1234567890, 27, Gender.MALE, true);
        RegisterResult prev = registry.registerVoter(person);
       
        //act       
        RegisterResult result = registry.registerVoter(person);
        
        //assert        
        assertEquals(RegisterResult.DUPLICATED, result);
    }
    
    @Test    
    public void should_NotAllowToVote_When_PersonIsDead () {
        //arrange        
        Person person = new Person("Juan", 1011320038, 19, Gender.MALE, false);
        
        //act        
        RegisterResult result = registry.registerVoter(person);
        
        //assert        
        assertEquals(RegisterResult.DEAD, result);
    }
    
    @Test    
    public void should_NotAllowToVote_When_PersonHasANegativeAge () {
        //arrange        
        Person person = new Person("Santiago", 1000327978, -14, Gender.MALE, true);
        
        //act        
        RegisterResult result = registry.registerVoter(person);
        
        //assert        
        assertEquals(RegisterResult.INVALID_AGE, result);
    }
    
    @Test    
    public void should_NotAllowToVote_When_PersonLessThan18 () {
        //arrange       
        Person person = new Person("Julieta", 1012345786, 16, Gender.FEMALE, true);
        
        //act        
        RegisterResult result = registry.registerVoter(person);
        
        //assert       
        assertEquals(RegisterResult.UNDERAGE, result);
    }
    
    @Test    
    public void should_AllowsToVote_When_AgeGreaterThan18 () {
        //arrange       
        Person person = new Person("Verónica", 52279783, 48, Gender.FEMALE, true);
        
        //act        
        RegisterResult result = registry.registerVoter(person);
        
        //assert        
        assertEquals(RegisterResult.VALID, result);
    }
```    
Completando la implementación del método registerVoter de la clase Register.java, para retornar lo esperado:

```
/**     
* Validates if a person is allowed to vote     
* @param p person who we are validating     
* @return a RegisterResult constant according to the validations     
*/    
public RegisterResult registerVoter(Person p) {
        if (people.containsKey(p.getId())) {
            return RegisterResult.DUPLICATED;
        } else if (!p.isAlive()) {
            return RegisterResult.DEAD;
        } else if (p.getAge() < 0) {
            return RegisterResult.INVALID_AGE;
        } else if (p.getAge() < 18) {
            return RegisterResult.UNDERAGE;
        }
        people.put(p.getId(), p);
        return RegisterResult.VALID;
    }
```

Ejecutando las pruebas desde maven:
<img src="/img/8.png" width="80%" height="80%"/>

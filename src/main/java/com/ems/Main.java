package com.ems;
import com.ems.service.EmployeeService;
import java.util.List;
public class Main {

    public static void main(String[] args) {
        System.out.println("Employee Management System");
        System.out.println("Sistema iniciado correctamente.");

        //creamos la variable de la clase por asi decirlo
        EmployeeService service = new EmployeeService();

        //creando objetos y registrandolos en en la lista
        Employee juan = new Employee(301, "Juan", 1.0/0);
        Employee maria = new Employee(401, "Maria", 3900);
        Employee jose = new Employee(301, "Jose", 40000);
        boolean resultadoMaria = service.registrarEmpleado(maria);
        boolean resultadoJuan = service.registrarEmpleado(juan);
        boolean resultadoJose = service.registrarEmpleado(jose);
        System.out.println("Maria registrada: "+resultadoMaria);
        System.out.println("Juan registrado: "+ resultadoJuan);
        System.out.println("Jose registrado: "+resultadoJose);


        List<Employee> empleados = service.listarEmpleados();

        for(Employee empleado : empleados){
            System.out.println("PRUEBA"+empleado);
        }
        //modificar sueldo
        int idBuscado = 401;
        try{
            boolean sueldoModificar = service.actualizarSueldo(idBuscado, -70000);
            if(sueldoModificar){
                System.out.println("Se le modifico el sueldo correctamente a: ");
            }
            else{   
                System.out.println("No se puede modificar este sueldo");
            }
        }
            catch(IllegalArgumentException e){
                System.out.println("Error: "+ e.getMessage());
            }
        
        // registrar empleados que ya estan registrados
        boolean registrado = service.registrarEmpleado(juan);
        if (registrado){
            System.out.println("Empleado registrado correctamente");
        }
        else{
            System.out.println("Ya existe un empleado con este ID");
        }

        int id = 401;
        Employee empleadoEncontrado = service.buscarPorID(id);
        if(empleadoEncontrado != null){
            System.out.println("Empleado encontrado ID:"+id+ empleadoEncontrado);
        }
        else{
            System.out.println("El ID "+id+ " es inexistente");
        }

        int idEliminar = 301;
        boolean eliminado = service.eliminarPorID(idEliminar);

        if (eliminado){
            System.out.println("Se elimino el empleado con el ID: "+ idEliminar);
        }
        else{
            System.out.println("El ID: "+idEliminar+" es inexistente");
        }
        boolean primerIntentoDeEliminarAMaria = service.eliminarPorID(401);
        System.out.println("Eliminando a maria primer intento "+primerIntentoDeEliminarAMaria );
        service.listarEmpleados();
        service.eliminarPorID(999);
        service.listarEmpleados();
        boolean segundoIntentoDeEliminarAMaria = service.eliminarPorID(401);
        System.out.println("Eliminando a maria segundo intento "+segundoIntentoDeEliminarAMaria);
        service.listarEmpleados();
    }
}

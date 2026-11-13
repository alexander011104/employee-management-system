package com.ems.service;
import com.ems.Employee;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeService {
    private List<Employee> empleados = new ArrayList<>();

    public boolean registrarEmpleado(Employee empleado){
        for(Employee empleadoAgregado: empleados){
            if(empleadoAgregado.getId() == empleado.getId()){
                return false;
            }
        }
        empleados.add(empleado);
        return true;
    }
    public List<Employee> listarEmpleados(){
        return Collections.unmodifiableList(empleados);
    }
    public Employee buscarPorID(int idBuscado){
        for(Employee empleadoActual: empleados){
            if(empleadoActual.getId() == idBuscado){
                return empleadoActual;
            }
        }
        return null;
    }
    public boolean eliminarPorID(int idBuscado){
        Employee empleadoAeliminar = null;
        for (Employee empleadoActual: empleados){
            if(empleadoActual.getId() == idBuscado){
                empleadoAeliminar = empleadoActual;
                break;
            }
        }
        if(empleadoAeliminar != null){
            empleados.remove(empleadoAeliminar);
            return true;
        }
        return false;
    }
    public boolean actualizarSueldo(int idBuscado, double nuevoSueldo){
        Employee empleadoEncontrado = buscarPorID(idBuscado);
        if(empleadoEncontrado != null){
            empleadoEncontrado.setSueldo(nuevoSueldo);
            return true;
        }
        return false;
    }
}

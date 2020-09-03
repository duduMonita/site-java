package entidades;

import entidades.PacienteAlergia;
import entidades.Prontuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-17T00:01:16")
@StaticMetamodel(Paciente.class)
public class Paciente_ { 

    public static volatile SingularAttribute<Paciente, Integer> idPaciente;
    public static volatile SingularAttribute<Paciente, String> telEmergencia;
    public static volatile CollectionAttribute<Paciente, Prontuario> prontuarioCollection;
    public static volatile CollectionAttribute<Paciente, PacienteAlergia> pacienteAlergiaCollection;

}
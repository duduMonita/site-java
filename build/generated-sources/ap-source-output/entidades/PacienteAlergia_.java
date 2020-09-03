package entidades;

import entidades.Alergia;
import entidades.Paciente;
import entidades.PacienteAlergiaPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-17T00:01:16")
@StaticMetamodel(PacienteAlergia.class)
public class PacienteAlergia_ { 

    public static volatile SingularAttribute<PacienteAlergia, PacienteAlergiaPK> pacienteAlergiaPK;
    public static volatile SingularAttribute<PacienteAlergia, Integer> nivelAlergia;
    public static volatile SingularAttribute<PacienteAlergia, Paciente> paciente;
    public static volatile SingularAttribute<PacienteAlergia, Alergia> alergia;

}
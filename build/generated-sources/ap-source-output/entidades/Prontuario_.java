package entidades;

import entidades.LocalFisico;
import entidades.Medico;
import entidades.Paciente;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-17T00:01:16")
@StaticMetamodel(Prontuario.class)
public class Prontuario_ { 

    public static volatile SingularAttribute<Prontuario, Date> dtConsulta;
    public static volatile SingularAttribute<Prontuario, Paciente> idPaciente;
    public static volatile SingularAttribute<Prontuario, String> observacao;
    public static volatile SingularAttribute<Prontuario, Boolean> situacao;
    public static volatile SingularAttribute<Prontuario, String> receita;
    public static volatile SingularAttribute<Prontuario, Integer> idProntuario;
    public static volatile SingularAttribute<Prontuario, Medico> idMedico;
    public static volatile SingularAttribute<Prontuario, LocalFisico> idLocalFisico;

}
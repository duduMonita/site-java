package entidades;

import entidades.PacienteAlergia;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-17T00:01:16")
@StaticMetamodel(Alergia.class)
public class Alergia_ { 

    public static volatile SingularAttribute<Alergia, Integer> idAlergia;
    public static volatile SingularAttribute<Alergia, String> descrAlergia;
    public static volatile CollectionAttribute<Alergia, PacienteAlergia> pacienteAlergiaCollection;

}
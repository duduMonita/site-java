package entidades;

import entidades.Prontuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-17T00:01:16")
@StaticMetamodel(LocalFisico.class)
public class LocalFisico_ { 

    public static volatile SingularAttribute<LocalFisico, String> nmLocalFisico;
    public static volatile CollectionAttribute<LocalFisico, Prontuario> prontuarioCollection;
    public static volatile SingularAttribute<LocalFisico, Integer> idLocalFisico;

}
package entidades;

import entidades.Pessoa;
import entidades.Prontuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-17T00:01:16")
@StaticMetamodel(Medico.class)
public class Medico_ { 

    public static volatile SingularAttribute<Medico, Pessoa> idPessoa;
    public static volatile SingularAttribute<Medico, Integer> idMedico;
    public static volatile CollectionAttribute<Medico, Prontuario> prontuarioCollection;
    public static volatile SingularAttribute<Medico, String> crm;

}
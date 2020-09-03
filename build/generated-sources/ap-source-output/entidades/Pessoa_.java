package entidades;

import entidades.Medico;
import entidades.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-11-17T00:01:16")
@StaticMetamodel(Pessoa.class)
public class Pessoa_ { 

    public static volatile SingularAttribute<Pessoa, String> cidade;
    public static volatile SingularAttribute<Pessoa, String> telefone;
    public static volatile SingularAttribute<Pessoa, String> endereco;
    public static volatile SingularAttribute<Pessoa, Integer> numero;
    public static volatile SingularAttribute<Pessoa, String> bairro;
    public static volatile SingularAttribute<Pessoa, String> nome;
    public static volatile CollectionAttribute<Pessoa, Usuario> usuarioCollection;
    public static volatile SingularAttribute<Pessoa, String> cep;
    public static volatile SingularAttribute<Pessoa, Integer> idPessoa;
    public static volatile SingularAttribute<Pessoa, String> naturalidade;
    public static volatile SingularAttribute<Pessoa, String> complemento;
    public static volatile SingularAttribute<Pessoa, String> rg;
    public static volatile CollectionAttribute<Pessoa, Medico> medicoCollection;
    public static volatile SingularAttribute<Pessoa, String> cpf;
    public static volatile SingularAttribute<Pessoa, Date> dtNascimento;
    public static volatile SingularAttribute<Pessoa, String> sexo;
    public static volatile SingularAttribute<Pessoa, String> nomeMae;

}
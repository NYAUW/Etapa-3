package br.com.contmatic.telefone;

import static br.com.contmatic.telefone.DddsTelefone.SAO_PAULO;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.contmatic.annotation.ValidateAnnotations;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

/**
 * The Class TelefoneTest.
 */
public class TelefoneTest {

    /** The telefone. */
    Telefone telefone;

    /** The valid. */
    ValidateAnnotations<Object> valid;

    /**
     * Set up.
     */
    @BeforeClass
    public static void setUp() {
        FixtureFactoryLoader.loadTemplates("br.com.contmatic.FixtureFactory");
    }

    /**
     * Deve verificar igualdade de classes equals.
     */
    @Before
    public void deve_verificar_igualdade_de_classes_equals() {
        Telefone telefone = new Telefone(SAO_PAULO, "20117414", "201", TipoTelefone.FIXO);
        Telefone telefone2 = new Telefone(SAO_PAULO, "20117414", "201", TipoTelefone.FIXO);
        assertEquals(telefone, telefone2);
        assertEquals(telefone.hashCode(), telefone2.hashCode());
    }

    @Test
    public void deve_armazenar_ddd() {
        Telefone telefone = Fixture.from(Telefone.class).gimme("telefone");
        telefone.getDdd().getDdd();
        valid = new ValidateAnnotations<>();
        assertFalse(valid.returnAnnotationMsgError(telefone));
    }

    @Test
    public void deve_armazenar_ddd_nulo() {
        Telefone telefone = Fixture.from(Telefone.class).gimme("telefone");
        telefone.setDdd(null);
        valid = new ValidateAnnotations<>();
        assertTrue(valid.returnAnnotationMsgError(telefone));
    }

    /**
     * Deve armazenar numero gerado automaticamente com objetos fake.
     */
    @Test
    public void deve_armazenar_numero_gerado_automaticamente_com_objetos_fake() {
        Telefone telefone = Fixture.from(Telefone.class).gimme("telefone");
        telefone.getNumero();
        valid = new ValidateAnnotations<>();
        assertFalse(valid.returnAnnotationMsgError(telefone));
    }

    @Test
    public void deve_armazenar_numero_null() {
        Telefone telefone = Fixture.from(Telefone.class).gimme("telefone");
        telefone.setNumero(null);
        valid = new ValidateAnnotations<>();
        assertTrue(valid.returnAnnotationMsgError(telefone));
    }

    @Test
    public void deve_armazenar_numero_vazio() {
        Telefone telefone = Fixture.from(Telefone.class).gimme("telefone");
        telefone.setNumero("");
        valid = new ValidateAnnotations<>();
        assertTrue(valid.returnAnnotationMsgError(telefone));
    }

    @Test
    public void deve_armazenar_numero_invalido() {
        Telefone telefone = Fixture.from(Telefone.class).gimme("telefone");
        telefone.setNumero("119315091677");
        valid = new ValidateAnnotations<>();
        assertTrue(valid.returnAnnotationMsgError(telefone));
    }

    @Test
    public void deve_armazenar_numero_com_caractere() {
        Telefone telefone = Fixture.from(Telefone.class).gimme("telefone");
        telefone.setNumero("djuffdd");
        valid = new ValidateAnnotations<>();
        assertTrue(valid.returnAnnotationMsgError(telefone));
    }

    @Test
    public void deve_armazenar_numero_com_caractere_e_numeros() {
        Telefone telefone = Fixture.from(Telefone.class).gimme("telefone");
        telefone.setNumero("djuffdd5897431");
        valid = new ValidateAnnotations<>();
        assertTrue(valid.returnAnnotationMsgError(telefone));
    }

    /**
     * Deve setar telefone manualmente simulando entrada de dados usuario.
     */
    @Test
    public void deve_setar_telefone_manualmente_simulando_entrada_de_dados_usuario() {
        Telefone telefone = Fixture.from(Telefone.class).gimme("telefone");
        telefone.setNumero("931509167");
        valid = new ValidateAnnotations<>();
        assertFalse(valid.returnAnnotationMsgError(telefone));
    }

    /**
     * Deve armazenar ramal gerado aleatoriamente com objetos fake.
     */
    @Test
    public void deve_armazenar_ramal_gerado_aleatoriamente_com_objetos_fake() {
        Telefone telefone = Fixture.from(Telefone.class).gimme("telefone");
        telefone.getRamal();
        valid = new ValidateAnnotations<>();
        assertFalse(valid.returnAnnotationMsgError(telefone));
    }

    /**
     * Deve setar ramal simulando entrada de dados usuario.
     */
    @Test
    public void deve_setar_ramal_simulando_entrada_de_dados_usuario() {
        Telefone telefone = Fixture.from(Telefone.class).gimme("telefone");
        telefone.setRamal("456");
        valid = new ValidateAnnotations<>();
        assertFalse(valid.returnAnnotationMsgError(telefone));
    }

    @Test
    public void deve_verificar_ramal_nulo() {
        Telefone telefone = Fixture.from(Telefone.class).gimme("telefone");
        telefone.setRamal(null);
        valid = new ValidateAnnotations<>();
        assertTrue(valid.returnAnnotationMsgError(telefone));
    }

    @Test
    public void deve_verificar_ramal_vazio() {
        Telefone telefone = Fixture.from(Telefone.class).gimme("telefone");
        telefone.setRamal("");
        valid = new ValidateAnnotations<>();
        assertTrue(valid.returnAnnotationMsgError(telefone));
    }

    /**
     * Deve armazenar tipo gerado aleatoriamente com objetos fake.
     */
    @Test
    public void deve_armazenar_tipo_gerado_aleatoriamente_com_objetos_fake() {
        Telefone telefone = Fixture.from(Telefone.class).gimme("telefone");
        telefone.getTipo();
        valid = new ValidateAnnotations<>();
        assertFalse(valid.returnAnnotationMsgError(telefone));
    }

    /**
     * Deve setar tipo manualmente simulando entrada de dados usuario.
     */
    @Test
    public void deve_setar_tipo_manualmente_simulando_entrada_de_dados_usuario() {
        Telefone telefone = Fixture.from(Telefone.class).gimme("telefone");
        telefone.setTipo(TipoTelefone.FIXO);
        valid = new ValidateAnnotations<>();
        assertFalse(valid.returnAnnotationMsgError(telefone));
    }

    @Test
    public void deve_verificar_tipo_nulo() {
        Telefone telefone = Fixture.from(Telefone.class).gimme("telefone");
        telefone.setTipo(null);
        valid = new ValidateAnnotations<>();
        assertTrue(valid.returnAnnotationMsgError(telefone));
    }

}

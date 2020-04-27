package br.com.contmatic.telefone;

import static br.com.contmatic.enums.EnumTipoTelefone.FIXO;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.com.contmatic.annotation.ValidateAnnotations;
import br.com.contmatic.object.easy.EasyRandomClass;

/**
 * The Class TelefoneTest.
 */
public class TelefoneTest {

    private static EasyRandomClass randomObject = EasyRandomClass.instanciaEasyRandomClass();

    /**
     * Deve verificar igualdade de classes equals.
     */
    @Before
    public void deve_verificar_igualdade_de_classes_equals() {
        Telefone telefone = randomObject.telefoneRandomizer();
        Telefone telefone2 = randomObject.telefoneRandomizer();
        assertNotEquals(telefone, telefone2);
    }
    
    @Before
    public void deve_verificar_igualdade_de_classes_hashcode() {
        Telefone telefone = randomObject.telefoneRandomizer();
        Telefone telefone2 = randomObject.telefoneRandomizer();
        assertNotEquals(telefone.hashCode(), telefone2.hashCode());
    }

    @Test
    public void deve_armazenar_ddd() {
        Telefone telefone = randomObject.telefoneRandomizer();
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(telefone.getDdd()));
    }

    @Test
    public void deve_armazenar_ddd_nulo() {
        Telefone telefone = randomObject.telefoneRandomizer();
        telefone.setDdd(null);
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(telefone));
    }

    /**
     * Deve armazenar numero gerado automaticamente com objetos fake.
     */
    @Test
    public void deve_armazenar_numero_gerado_automaticamente_com_objetos_fake() {
        Telefone telefone = randomObject.telefoneRandomizer();
        telefone.getNumero();
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(telefone));
    }

    @Test
    public void deve_armazenar_numero_null() {
        Telefone telefone = randomObject.telefoneRandomizer();
        telefone.setNumero(null);
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(telefone));
    }

    @Test
    public void deve_armazenar_numero_vazio() {
        Telefone telefone = randomObject.telefoneRandomizer();
        telefone.setNumero("");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(telefone));
    }

    @Test
    public void deve_armazenar_numero_invalido() {
        Telefone telefone = randomObject.telefoneRandomizer();
        telefone.setNumero("119315091677");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(telefone));
    }

    @Test
    public void deve_armazenar_numero_com_caractere() {
        Telefone telefone = randomObject.telefoneRandomizer();
        telefone.setNumero("djuffdd");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(telefone));
    }

    @Test
    public void deve_armazenar_numero_com_caractere_e_numeros() {
        Telefone telefone = randomObject.telefoneRandomizer();
        telefone.setNumero("djuffdd5897431");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(telefone));
    }

    /**
     * Deve setar telefone manualmente simulando entrada de dados usuario.
     */
    @Test
    public void deve_setar_telefone_manualmente_simulando_entrada_de_dados_usuario() {
        Telefone telefone = randomObject.telefoneRandomizer();
        telefone.setNumero("931509167");
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(telefone));
    }

    /**
     * Deve armazenar ramal gerado aleatoriamente com objetos fake.
     */
    @Test
    public void deve_armazenar_ramal_gerado_aleatoriamente_com_objetos_fake() {
        Telefone telefone = randomObject.telefoneRandomizer();
        telefone.getRamal();
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(telefone));
    }

    /**
     * Deve setar ramal simulando entrada de dados usuario.
     */
    @Test
    public void deve_setar_ramal_simulando_entrada_de_dados_usuario() {
        Telefone telefone = randomObject.telefoneRandomizer();
        telefone.setRamal("456");
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(telefone));
    }

    @Test
    public void deve_verificar_ramal_nulo() {
        Telefone telefone = randomObject.telefoneRandomizer();
        telefone.setRamal(null);
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(telefone));
    }

    @Test
    public void deve_verificar_ramal_vazio() {
        Telefone telefone = randomObject.telefoneRandomizer();
        telefone.setRamal("");
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(telefone));
    }

    /**
     * Deve armazenar tipo gerado aleatoriamente com objetos fake.
     */
    @Test
    public void deve_armazenar_tipo_gerado_aleatoriamente_com_objetos_fake() {
        Telefone telefone = randomObject.telefoneRandomizer();
        telefone.getTipo();
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(telefone));
    }

    /**
     * Deve setar tipo manualmente simulando entrada de dados usuario.
     */
    @Test
    public void deve_setar_tipo_manualmente_simulando_entrada_de_dados_usuario() {
        Telefone telefone = randomObject.telefoneRandomizer();
        telefone.setTipo(FIXO.getTipo());
        assertFalse(ValidateAnnotations.returnAnnotationMsgError(telefone));
    }

    @Test
    public void deve_verificar_tipo_nulo() {
        Telefone telefone = randomObject.telefoneRandomizer();
        telefone.setTipo(null);
        assertTrue(ValidateAnnotations.returnAnnotationMsgError(telefone));
    }

}

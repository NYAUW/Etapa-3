package br.com.contmatic.endereco;

import static br.com.contmatic.enums.EnumBairros.SAPOPEMBA;
import static br.com.contmatic.enums.EnumTipoEndereco.CASA;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.contmatic.easyrandom.EasyRandomClass;
import br.com.contmatic.validator.ValidadorAnnotations;
/**
 * The Class EnderecoTest.
 */
public class EnderecoTest {

    private static br.com.contmatic.easyrandom.EasyRandomClass randomObject = EasyRandomClass.instanciaEasyRandomClass();

    @Test
    public void deve_verificar_saida_rua() {
        Endereco endereco = randomObject.enderecoRandomizer();
        assertTrue(endereco.toString().contains("rua"));
    }

    @Test
    public void deve_verificar_saida_bairro() {
        Endereco endereco = randomObject.enderecoRandomizer();
        assertTrue(endereco.toString().contains("bairro"));
    }

    @Test
    public void deve_verificar_saida_numero() {
        Endereco endereco = randomObject.enderecoRandomizer();
        assertTrue(endereco.toString().contains("numero"));
    }

    @Test
    public void deve_verificar_saida_regiao() {
        Endereco endereco = randomObject.enderecoRandomizer();
        assertTrue(endereco.toString().contains("regiao"));
    }

    @Test
    public void deve_verificar_saida_cep() {
        Endereco endereco = randomObject.enderecoRandomizer();
        assertTrue(endereco.toString().contains("cep"));
    }

    @Test
    public void deve_verificar_saida_tipo() {
        Endereco endereco = randomObject.enderecoRandomizer();
        assertTrue(endereco.toString().contains("tipo"));
    }

    /**
     * Deve comparar as classes com hashcode.
     */
    @Test
    public void deve_comparar_as_classes_com_hashcode() {
        Endereco endereco = randomObject.enderecoRandomizer();
        Endereco comparator = randomObject.enderecoRandomizer();
        assertNotEquals(endereco.hashCode(), comparator.hashCode());
    }

    /**
     * Deve comparar as classes com equals.
     */
    @Test
    public void deve_comparar_as_classes_com_equals() {
        Endereco endereco = randomObject.enderecoRandomizer();
        Endereco comparator = randomObject.enderecoRandomizer();
        assertNotEquals(endereco, comparator);
    }

    /**
     * Deve armazenar rua gerada aleatoriamente com os objetos fake.
     */
    @Test
    public void deve_armazenar_rua_gerada_aleatoriamente_com_os_objetos_fake() {
        Endereco endereco = randomObject.enderecoRandomizer();
        assertFalse(ValidadorAnnotations.returnAnnotationMsgError(endereco.getRua()));
    }

    /**
     * Deve armazenar rua simulando entrada de dados do usuario.
     */
    @Test
    public void deve_armazenar_rua_simulando_entrada_de_dados_do_usuario() {
        Endereco endereco = randomObject.enderecoRandomizer();
        endereco.setRua("Rua Padre Estebao");
        assertFalse(ValidadorAnnotations.returnAnnotationMsgError(endereco));
    }

    @Test
    public void deve_verificar_rua_nula() {
        Endereco endereco = randomObject.enderecoRandomizer();
        endereco.setRua(null);
        assertTrue(ValidadorAnnotations.returnAnnotationMsgError(endereco));
    }

    @Test
    public void deve_verificar_rua_numerica() {
        Endereco endereco = randomObject.enderecoRandomizer();
        endereco.setRua("Ru4 Tu1ti");
        assertTrue(ValidadorAnnotations.returnAnnotationMsgError(endereco));
    }

    @Test
    public void deve_verificar_rua_vazia() {
        Endereco endereco = randomObject.enderecoRandomizer();
        endereco.setRua("");
        assertTrue(ValidadorAnnotations.returnAnnotationMsgError(endereco));
    }

    /**
     * Deve armazenar bairro gerado com objetos fake.
     */
    @Test
    public void deve_armazenar_bairro_gerado_com_objetos_fake() {
        Endereco endereco = randomObject.enderecoRandomizer();
        assertFalse(ValidadorAnnotations.returnAnnotationMsgError(endereco.getBairro()));
    }

    /**
     * Deve armazenar bairro simulando entrada de dados do usuario.
     */
    @Test
    public void deve_armazenar_bairro_simulando_entrada_de_dados_do_usuario() {
        Endereco endereco = randomObject.enderecoRandomizer();
        endereco.setBairro(SAPOPEMBA.getBairro());
        assertFalse(ValidadorAnnotations.returnAnnotationMsgError(endereco.getBairro()));
    }

    @Test
    public void deve_verificar_bairro_nulo() {
        Endereco endereco = randomObject.enderecoRandomizer();
        endereco.setBairro(null);
        assertTrue(ValidadorAnnotations.returnAnnotationMsgError(endereco));
    }

    /**
     * Deve setar numero simulando entrada de dados do usuario.
     */
    @Test
    public void deve_setar_numero_simulando_entrada_de_dados_do_usuario() {
        Endereco endereco = randomObject.enderecoRandomizer();
        endereco.setNumero(666);
        assertFalse(ValidadorAnnotations.returnAnnotationMsgError(endereco.getNumero()));
    }

    @Test
    public void deve_verificar_numero_maior_que_um() {
        Endereco endereco = randomObject.enderecoRandomizer();
        endereco.setNumero(0);
        assertTrue(ValidadorAnnotations.returnAnnotationMsgError(endereco));
    }

    /**
     * Deve armazenar numero gerado aleatoriamente com objetos fake.
     */
    @Test
    public void deve_armazenar_numero_gerado_aleatoriamente_com_objetos_fake() {
        Endereco endereco = randomObject.enderecoRandomizer();
        assertFalse(ValidadorAnnotations.returnAnnotationMsgError(endereco.getNumero()));
    }

    /**
     * Deve verificar regiao simulando entrada de dados usuario.
     */
    @Test
    public void deve_verificar_regiao_simulando_entrada_de_dados_usuario() {
        Endereco endereco = randomObject.enderecoRandomizer();
        endereco.setRegiao("Zona Leste");
        assertFalse(ValidadorAnnotations.returnAnnotationMsgError(endereco.getRegiao()));
    }

    /**
     * Deve armazenar regiao gerado com objetos fake.
     */
    @Test
    public void deve_armazenar_regiao_gerado_com_objetos_fake() {
        Endereco endereco = randomObject.enderecoRandomizer();
        assertFalse(ValidadorAnnotations.returnAnnotationMsgError(endereco.getRegiao()));
    }

    @Test
    public void deve_verificar_regiao_nulo() {
        Endereco endereco = randomObject.enderecoRandomizer();
        endereco.setRegiao(null);
        assertTrue(ValidadorAnnotations.returnAnnotationMsgError(endereco));
    }

    @Test
    public void deve_verificar_regiao_vazio() {
        Endereco endereco = randomObject.enderecoRandomizer();
        endereco.setRegiao("");
        assertTrue(ValidadorAnnotations.returnAnnotationMsgError(endereco));
    }

    @Test
    public void deve_verificar_regiao_numerico() {
        Endereco endereco = randomObject.enderecoRandomizer();
        endereco.setRegiao("Abc3");
        assertTrue(ValidadorAnnotations.returnAnnotationMsgError(endereco));
    }

    /**
     * Deve armazenar cep gerado automaricamente com objetos fake.
     */
    @Test
    public void deve_armazenar_cep_gerado_automaricamente_com_objetos_fake() {
        Endereco endereco = randomObject.enderecoRandomizer();
        assertFalse(ValidadorAnnotations.returnAnnotationMsgError(endereco.getCep()));
    }

    /**
     * Deve setar cep simulando entrada de dados do usuario.
     */
    @Test
    public void deve_setar_cep_simulando_entrada_de_dados_do_usuario() {
        Endereco endereco = randomObject.enderecoRandomizer();
        endereco.setCep("03977120");
        assertFalse(ValidadorAnnotations.returnAnnotationMsgError(endereco));
    }

    @Test
    public void deve_verificar_cep_nulo() {
        Endereco endereco = randomObject.enderecoRandomizer();
        endereco.setCep(null);
        assertTrue(ValidadorAnnotations.returnAnnotationMsgError(endereco));
    }

    @Test
    public void deve_verificar_cep_vazio() {
        Endereco endereco = randomObject.enderecoRandomizer();
        endereco.setCep("");
        assertTrue(ValidadorAnnotations.returnAnnotationMsgError(endereco));
    }

    @Test
    public void deve_verificar_cep_incompleto() {
        Endereco endereco = randomObject.enderecoRandomizer();
        endereco.setCep("03977");
        assertTrue(ValidadorAnnotations.returnAnnotationMsgError(endereco));
    }

    @Test
    public void deve_verificar_cep_com_letras() {
        Endereco endereco = randomObject.enderecoRandomizer();
        endereco.setCep("039sete7120");
        assertTrue(ValidadorAnnotations.returnAnnotationMsgError(endereco));
    }

    /**
     * Deve armazenar tipo gerado sorteado com objetos fake.
     */
    @Test
    public void deve_armazenar_tipo_gerado_sorteado_com_objetos_fake() {
        Endereco endereco = randomObject.enderecoRandomizer();
        assertFalse(ValidadorAnnotations.returnAnnotationMsgError(endereco.getTipo()));
    }

    /**
     * Deve armazenar tipo setado diretamente simulando entrada de dados do usuario.
     */
    @Test
    public void deve_armazenar_tipo_setado_diretamente_simulando_entrada_de_dados_do_usuario() {
        Endereco endereco = randomObject.enderecoRandomizer();
        endereco.setTipo(CASA);
        assertFalse(ValidadorAnnotations.returnAnnotationMsgError(endereco.getTipo()));
    }

    @Test
    public void deve_armazenar_regiao_com_enum() {
        Endereco endereco = randomObject.enderecoRandomizer();
        endereco.setRegiao(CASA.getTipo());
        assertFalse(ValidadorAnnotations.returnAnnotationMsgError(endereco.getTipo()));
    }

    @Test
    public void deve_verificar_tipo_nulo() {
        Endereco endereco = randomObject.enderecoRandomizer();
        endereco.setTipo(null);
        assertTrue(ValidadorAnnotations.returnAnnotationMsgError(endereco));
    }
}
package com.psikus.tdd;
 
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;
 
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
 
public class Interfejs {
        @Test
        public void CyfrokradTest1(){
                Kontrakt target = new Kontrakt();
                Integer actual = target.cyfrokrad(4);
                assertNull("should be null",actual);
        }
       
        @Test
        public void CyfrokradTest2(){
                Kontrakt target = new Kontrakt();
                Integer dlugoscpo=target.cyfrokrad(4413).toString().length();
                assertThat("shouldbeequal",dlugoscpo.equals(3));
        }
        @Test
        public void CyfrokradTest3(){
                Kontrakt target = new Kontrakt();
                Integer checknull = target.cyfrokrad(01);
                assertNull("should be null",checknull);
        }
        @Test
        public void CyfrokradTest4(){
                Kontrakt target = new Kontrakt();
                Integer checknull = target.cyfrokrad(0);
                assertNull("should be null",checknull);
        }
       
        @Test
        public void CyfrokradTest5(){
                Kontrakt target = new Kontrakt();
                Integer shouldnotbenull=target.cyfrokrad(4413);
                assertNotNull("should not be null", shouldnotbenull);
        }
        @Test
        public void CyfrokradTest6(){
                Kontrakt target = new Kontrakt();
                Integer result=target.cyfrokrad(4413);
                assertThat("one of them should be equal",result==441|| result==413 || result==443 );
               
        }
        @Test
        public void CyfrokradTest7(){
                Kontrakt target = new Kontrakt();
                Integer result=target.cyfrokrad(-4413);
                assertThat("one of them should be equal",result==(-441)|| result==(-413) || result==(-443) );
        }
//////////////////////////////////////////////////////////////////////////////////////////
 
        @Test
        public void hultajchochlaTest1() throws NieudanyPsikusException{
                Kontrakt target = new Kontrakt();
                Integer result=target.hultajchochla(-12);
                Integer expected = -21;
                Integer notexpected=-12;
                assertEquals(result,expected);
                assertNotEquals(result,notexpected);
        }
       
        @Test
        public void hultajchochlaTestIfCorrect() throws NieudanyPsikusException
        {
        	Kontrakt target = new Kontrakt();
        	Integer result = target.hultajchochla(39);
        	Integer expected = 93;
        	assertTrue(result.equals(expected));
        }
        @Test
        public void hultajchochlaTest2() throws NieudanyPsikusException{
                boolean thrown=false;
                try{
                        Kontrakt target = new Kontrakt();
                        target.hultajchochla(313);
                       
                }
                catch(NieudanyPsikusException ex)
                {
                        thrown=true;
                }
                assertFalse(thrown);
        }
       
        @Rule
    	public ExpectedException thrown2 = ExpectedException.none();
        @Test
        public void hultajchochlaTest7() throws NieudanyPsikusException{
 
                        thrown2.expect(NieudanyPsikusException.class);
                        //thrown2.expectMessage("Jedna cyfra");
                        Kontrakt target = new Kontrakt();
                        target.hultajchochla(2);
        }
       
       
        @Test
        public void hultajchochlaTest3() throws NieudanyPsikusException {
       
                boolean thrown=false;
                try{
                        Kontrakt target = new Kontrakt();
                        target.hultajchochla(3);
                        fail("Oczekujemy NieudanyPsikusException by zostal wylapany");
                }
                catch(NieudanyPsikusException ex)
                {
                        thrown=true;
                }
                assertTrue(thrown);
        }
       
        @Test
        public void hultajchochlaTest4() throws NieudanyPsikusException {
                Kontrakt target = new Kontrakt();
                Integer result;
                try{
                        target.hultajchochla(2);
                        fail("Oczekujemy NieudanyPsikusException by zostal wylapany");
                }
                catch(NieudanyPsikusException ex)
                {
                        assertEquals(NieudanyPsikusException.class,ex.getClass());
                        assertTrue(NieudanyPsikusException.class==ex.getClass());
                }
               
        }
        @Test(expected = NieudanyPsikusException.class)  
        public void hultajchochlaTest9() throws NieudanyPsikusException  {
                Kontrakt target = new Kontrakt();
                target.hultajchochla(1);
        }
       
        @Test
        public void hultajchochlaTest5() throws NieudanyPsikusException {
                Kontrakt target = new Kontrakt();
                Integer result;
                String expected="Jedna cyfra";
                try{
                        target.hultajchochla(2);
                        fail("Oczekujemy NieudanyPsikusException by zostal wylapany");
                       
                }
                catch(NieudanyPsikusException ex)
                {
                        //assertEquals(expected,ex.getMessage());
                        //assertTrue(expected==ex.getMessage());
                }
               
        }
        @Test
        public void hultajchochlaTest6() throws NieudanyPsikusException {
                Kontrakt target = new Kontrakt();
                Integer result;
                result = target.hultajchochla(213);
                //we expect 312 or 231 or 123
                Integer expected1=123;
                Integer expected2=312;
                Integer expected3=231;
                assertThat("one of them should be equal", result.equals(expected1)|| result.equals(expected2) || result.equals(expected3));
        }
       
       
        @Test
        public void hultajchochlaTest() throws NieudanyPsikusException{
                Kontrakt target = new Kontrakt();
                Integer result=target.hultajchochla(2123);
                String resul=result.toString();
                assertThat(resul, both(containsString("2")).and(containsString("3")));
               
        }
        ////////////////////////////////////////////////////////////////////////////////////////////
        @Test//changing 3->8,7->1,6->9
        public void nieksztaltek6() throws NieudanyPsikusException{
                Kontrakt target = new Kontrakt();
                Integer result=target.nieksztaltek(1234567890);
                Integer expected1=1284567890;
                Integer expected2=1234597890;
                Integer expected3=1234561890;
                assertThat("one of expected should be equal",result.equals(expected1) || result.equals(expected2) || result.equals(expected3));
               
        }
        @Test//testy referencji example
        public void nieksztaltekTest3(){
                Kontrakt target = new Kontrakt();
                Kontrakt target2 = new Kontrakt();
                assertNotSame("should not be same objects",target,target2);
                target=target2;
                assertSame("now should be same-reference to object2",target,target2);
        }
        @Test
        public void nieksztaltekTest1(){
                Kontrakt target = new Kontrakt();
                Integer result=target.nieksztaltek(2122);
                Integer expected=2122;
                assertEquals("should be equal",result,expected);
               
        }
       
        @Test
        public void nieksztaltekTest4(){
                Kontrakt target = new Kontrakt();
                Integer result=target.nieksztaltek(2123);
                Integer notexpected=2122;
                Integer expected=2128;
                assertEquals("should not be equals",result,expected);
                assertNotEquals("should not be equals",result,notexpected);
               
        }
       
       
        @Test//Just to test assertArrayEquals
        public void nieksztaltekTest5(){
                Kontrakt target = new Kontrakt();
                Integer result=target.nieksztaltek(2123);
                String resul=result.toString();
                byte[] expected=resul.getBytes();
                byte[] expected2="2128".getBytes();
       
                assertArrayEquals("arrays should be equals",expected,expected2);
       
        }
        @Test//Just to test assertArrayEquals //changing 3->8,7->1,6->9
        public void nieksztaltekTest8(){
                Kontrakt target = new Kontrakt();
                Integer result=target.nieksztaltek(2123);
               
                assertThat(result,is(2128));
       
        }
       
        // JUnit Matchers assertThat
        @Test
        public void nieksztaltekTest6(){
                Kontrakt target = new Kontrakt();
                Integer result=target.nieksztaltek(2123);
                String resul=result.toString();
                assertThat(resul, both(containsString("8")).and(containsString("2")));
               
        }
        @Test
        public void nieksztaltekTest7(){
                Kontrakt target = new Kontrakt();
                Integer result=target.nieksztaltek(2123);
                assertThat(result, not(allOf(equalTo(2127),equalTo(2122))));
               
        }
        @Test
        public void nieksztaltekTest9(){
                Kontrakt target = new Kontrakt();
                Integer result=target.nieksztaltek(2123);
                assertThat(result, not(allOf(equalTo(2127),equalTo(2122))));
               
        }
        @Test
        public void nieksztaltekTest10(){
                Kontrakt target = new Kontrakt();
                Integer result=target.nieksztaltek(367);
                assertThat(result, anyOf(equalTo(867),equalTo(397),equalTo(361)));
               
        }
}
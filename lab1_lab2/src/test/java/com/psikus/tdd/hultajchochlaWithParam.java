package com.psikus.tdd;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class hultajchochlaWithParam {
	  		@Parameters
	  		public static Collection<Object[]> data() {
	  	        return Arrays.asList(new Object[][] {
	  	                 { 111, 111 }, {999999999,999999999 } ,{21,12},{ 222, 222 }, { -31, -13 }, 
	  	           });
	  	    }
			private Integer expected;
            private Integer input;
           
            public hultajchochlaWithParam(Integer expectedResult,Integer input1) {
                                            this.expected = expectedResult;
                                            this.input = input1;
                   
                                        }
          
             
   
            @Test
            public void TestingwithParameters() throws NieudanyPsikusException{
                     Kontrakt target = new Kontrakt();
                    
                     assertEquals(expected, (target.hultajchochla(input)));	
            }
   
    
}

package junit;

import static org.junit.Assert.*;

import org.junit.Test;

class JunitTest {
	
	@Test
	void test() {		
					
			System.out.println(" add test");
			Calculator calculator = new Calculator();
			assertEquals(2, calculator.add(1,1));
	
	}
			 protected int value1, value2;
				   
			  @Test
			  	void setUp(){
				  System.out.println("value");
			      value1 = 3;
			      value2 = 3;
			   }

			  @Test
			  void testAdd(){
				   System.out.println("test");
			      double result = value1 + value2;
			      assertTrue(result == 6);
			     
			   }

	@Test
	void testFail() {
		System.out.println("add fail");					
		Calculator calculator = new Calculator();
		assertEquals(2, calculator.add(2,1));
	}
	 @Test		
	    public void testAssert(){					
	        		
	        //Variable declaration		
	        String string1="Junit";					
	        String string2="Junit";					
	        String string3="test";					
	        String string4="test";					
	        String string5=null;					
	        int variable1=1;					
	        int	variable2=2;					
	        int[] airethematicArrary1 = { 1, 2, 3 };					
	        int[] airethematicArrary2 = { 1, 2, 3 };					
	        		
	        //Assert statements		
	        assertEquals(string1,string2);	
	        System.out.println("equals");	
	        assertSame(string3, string4);	//samma som equals med + samma
	        System.out.println("same ");	
	        assertNotSame(string1, string3);
	        System.out.println("not same");	
	        assertNotNull(string1);	
	        System.out.println("not null");	
	        assertNull(string5);	
	        System.out.println("null");	
	        assertTrue(variable1<variable2);
	        System.out.println("true");
	        assertArrayEquals(airethematicArrary1, airethematicArrary2);
	        System.out.println("array");	
	    }		
	}


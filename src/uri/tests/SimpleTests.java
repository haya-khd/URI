package uri.tests;

import static org.junit.Assert.assertNotNull;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail; 


import org.junit.Test;

import uri.Host;
import uri.Uri;
import uri.IPv4Address;
import uri.UriParser;
import uri.UriParserFactory;

/**
 * This class provides a very simple example of how to write tests for this project.
 * You can implement your own tests within this class or any other class within this package.
 * Tests in other packages will not be run and considered for completion of the project.
 */
public class SimpleTests {

	/**
	 * Helper function to determine if the given host is an instance of {@link IPv4Address}.
	 *
	 * @param host the host
	 * @return {@code true} if the host is an instance of {@link IPv4Address}
	 */
	public boolean isIPv4Address(Host host) {
		return host instanceof IPv4Address;
	}

	/**
	 * Helper function to retrieve the byte array representation of a given host which must be an instance of {@link IPv4Address}.
	 *
	 * @param host the host
	 * @return the byte array representation of the IPv4 address
	 */
	public byte[] getIPv4Octets(Host host) {
		if (!isIPv4Address(host))
			throw new IllegalArgumentException("host must be an IPv4 address");
		return ((IPv4Address) host).getOctets();
	}
	

	@Test
		public void testNonNull() {
			assertNotNull(UriParserFactory.create("scheme://").parse());
		}

	@Test
	
	public void testNegativeSimple() {
		assertNull(UriParserFactory.create("").parse());
	}

	@Test
	public void testIPv4AddressSimple() {
		Host host = UriParserFactory.create("scheme://1.2.3.4").parse().getHost();
		assertTrue("host must be an IPv4 address", isIPv4Address(host));
	}
	/*SchemaTest*/
	
	@Test
	public void testSchemaTrue1() {
         
		String testschema1= UriParserFactory.create("schema2://prog2.de").parse().getScheme();
		assertEquals("schema2",testschema1);
		
	}
	@Test
	public void testSchemaTrue2() {
         
		String testschema2= UriParserFactory.create("https://prog2.de").parse().getScheme();
		assertEquals("https",testschema2);
		
	}
	@Test
	(expected=NullPointerException.class)
	public void testSchemaFalse1() {
         
		String testschemaFalse1= UriParserFactory.create(" ://prog2.de").parse().getScheme();
		fail(testschemaFalse1);
		
	}
	@Test
	(expected=NullPointerException.class)
	public void testSchemaFalse2() {
         
		String testschemaFalse2= UriParserFactory.create("23hlskj://prog2.de").parse().getScheme();
		fail(testschemaFalse2);
		
	}
	@Test
	(expected=NullPointerException.class)
	public void testSchemaFalse3() {
         
		String testschemaFalse3= UriParserFactory.create("http.s://prog2.de").parse().getScheme();
	    fail(testschemaFalse3);
		
	}
	@Test
	(expected=NullPointerException.class)
	public void testSchemaFalse4() {
         
		String testschemaFalse4= UriParserFactory.create("4532364://prog2.de").parse().getScheme();
		fail(testschemaFalse4);
		
	}
	@Test
	(expected=NullPointerException.class)
	public void testSchemaFalse5() {
         
		String testschemaFalse5= UriParserFactory.create("-http://prog2.de").parse().getScheme();
		fail(testschemaFalse5);
		
	}
	
	
	@Test
	public void testSchemaNull() {
		
		assertNull(UriParserFactory.create("://prog2.de").parse().getScheme());
	}
	
	
	
	/*tests if userinfo ":" hat. */
	/*Fehler
	/*NullPointerException:null**/
	@Test
	public void testUserInfoTrue1(){

		String createUserInfoTrue1=UriParserFactory.create("https://::@uniSaar.de/info?COOKIES").parse().getUserInfo();
		assertEquals("::",createUserInfoTrue1);
	}
	@Test
	public void testUserInfoTrue2(){

		String createUserInfoTrue2=UriParserFactory.create("https://:prog2@uniSaar.de/info?COOKIES").parse().getUserInfo();
		assertEquals(":prog2",createUserInfoTrue2);
	}
	@Test
	public void testUserInfoTrue3(){

		String createUserInfoTrue3=UriParserFactory.create("https://:Prog2@uniSaar.de/info?COOKIES").parse().getUserInfo();
		assertEquals(":Prog2",createUserInfoTrue3);
	}
	@Test
	public void testUserInfoTrue4(){

		String createUserInfoTrue4=UriParserFactory.create("https://:PROG2@uniSaar.de/info?COOKIES").parse().getUserInfo();
		assertEquals(":PROG2",createUserInfoTrue4);
	}

	@Test
	public void testUserInfoTrue5() {

		String createUserInfoTrue5 = UriParserFactory.create("https://:PROG@uniSaar.de/info?COOKIES").parse().getUserInfo();
		assertEquals(":PROG",createUserInfoTrue5);
		
	}
	@Test
	public void testUserInfoTrue6() {

		String createUserInfoTrue6 = UriParserFactory.create("https://:prog@uniSaar.de/info?COOKIES").parse().getUserInfo();
		assertEquals(":prog",createUserInfoTrue6);
		
	}
	@Test
	public void testUserInfoTrue7() {

		String createUserInfoTrue7 = UriParserFactory.create("https://PROG@uniSaar.de/info?COOKIES").parse().getUserInfo();
		assertEquals("PROG",createUserInfoTrue7);
		
	}
	@Test
	public void testUserInfoTrue8() {

		String createUserInfoTrue8 = UriParserFactory.create("https://prog@uniSaar.de/info?COOKIES").parse().getUserInfo();
		assertEquals("prog",createUserInfoTrue8);
		
	}
	@Test
	public void testUserInfoTrue9() {

		String createUserInfoTrue9 = UriParserFactory.create("https://:%AF@uniSaar.de/info?COOKIES").parse().getUserInfo();
		assertEquals(":%AF",createUserInfoTrue9);
		
	}
	@Test
	public void testUserInfoTrue10() {

		String createUserInfoTrue10 = UriParserFactory.create("https://:%A9@uniSaar.de/info?COOKIES").parse().getUserInfo();
		assertEquals(":%A9",createUserInfoTrue10);
	}
	@Test
	public void testUserInfoTrue11() {

		String createUserInfoTrue11 = UriParserFactory.create("https://%F9@uniSaar.de/info?COOKIES").parse().getUserInfo();
		assertEquals("%F9",createUserInfoTrue11);
	}
	@Test
	public void testUserInfoTrue12() {

		String createUserInfoTrue12 = UriParserFactory.create("https://:%Aa@uniSaar.de/info?COOKIES").parse().getUserInfo();
		assertEquals(":%Aa",createUserInfoTrue12);
	}
	@Test
	public void testUserInfoTrue13() {

		String createUserInfoTrue13 = UriParserFactory.create("https://:%fa@uniSaar.de/info?COOKIES").parse().getUserInfo();
		assertEquals(":%fa",createUserInfoTrue13);
	}
	@Test
	public void testUserInfoTrue14() {

		String createUserInfoTrue14 = UriParserFactory.create("https://%fa@uniSaar.de/info?COOKIES").parse().getUserInfo();
		assertEquals("%fa",createUserInfoTrue14);
	}
	@Test
	public void testUserInfoTrue15() {

		String createUserInfoTrue15 = UriParserFactory.create("https://:%a7@uniSaar.de/info?COOKIES").parse().getUserInfo();
		assertEquals(":%a7",createUserInfoTrue15);
	}
	@Test
	public void testUserInfoTrue16() {

		String createUserInfoTrue16 = UriParserFactory.create("https://%c4@uniSaar.de/info?COOKIES").parse().getUserInfo();
		assertEquals("%c4",createUserInfoTrue16);
	}
	@Test
	public void testNullOptionalUserInfo() {
		
		assertNull(UriParserFactory.create("schema://@uniSaar.de/info?cookies=true").parse().getUserInfo());
	}
	
	@Test
	(expected=NullPointerException.class)
	public void testUserInfoFalse1() {
		
		String createUserInfoFalse1=UriParserFactory.create("https://prog_2@uniSaar.de/info?COOKIES").parse().getUserInfo();
		fail(createUserInfoFalse1);
	}
	@Test
	(expected=NullPointerException.class)
	public void testUserInfoFalse2() {
		
		String createUserInfoFalse2=UriParserFactory.create("https://%123@uniSaar.de/info?COOKIES").parse().getUserInfo();
		fail(createUserInfoFalse2);
	}
	@Test
	(expected=NullPointerException.class)
	public void testUserInfoFalse3() {
		
		String createUserInfoFalse3=UriParserFactory.create("https://%UI@uniSaar.de/info?COOKIES").parse().getUserInfo();
		fail(createUserInfoFalse3);
	}
	@Test
	(expected=NullPointerException.class)
	public void testUserInfoFalse4() {
		
		String createUserInfoFalse4=UriParserFactory.create("https://h a@uniSaar.de/info?COOKIES").parse().getUserInfo();
		fail(createUserInfoFalse4);
	}
	@Test
	(expected=NullPointerException.class)
	public void testUserInfoFalse5() {
		
		String createUserInfoFalse5=UriParserFactory.create("https://h-a@uniSaar.de/info?COOKIES").parse().getUserInfo();
		fail(createUserInfoFalse5);
	}
	/*Path*/
	@Test
	public void testPathtrue1() {
		
		String createPathTrue1=UriParserFactory.create( "https://prog2@uniSaar.de/info?COOKIES").parse().getPath();
		assertEquals("/info",createPathTrue1);
	}
	@Test
	public void testPathtrue2() {
		
		String createPathTrue2=UriParserFactory.create( "https://prog2@uniSaar.de/INFO?COOKIES").parse().getPath();
		assertEquals("/INFO",createPathTrue2);
	}
	@Test
	public void testPathtrue3() {
		
		String createPathTrue3=UriParserFactory.create( "https://prog2@uniSaar.de/Info3?COOKIES").parse().getPath();
		assertEquals("/Info3",createPathTrue3);
	}
	@Test
	public void testPathtrue4() {
		
		String createPathTrue4=UriParserFactory.create( "https://prog2@uniSaar.de/123?COOKIES").parse().getPath();
		assertEquals("/123",createPathTrue4);
	}
	@Test
	public void testPathtrue5() {
		
		String createPathTrue5=UriParserFactory.create( "https://prog2@uniSaar.de/info2?COOKIES").parse().getPath();
		assertEquals("/info2",createPathTrue5);
	}
	@Test
	public void testPathtrue6() {
		
		String createPathTrue6=UriParserFactory.create( "https://prog2@uniSaar.de/INFO2?COOKIES").parse().getPath();
		assertEquals("/INFO2",createPathTrue6);
	}
	@Test
	public void testPathtrue7() {
		
		String createPathTrue7=UriParserFactory.create( "https://prog2@uniSaar.de/%23?COOKIES").parse().getPath();
		assertEquals("/%23",createPathTrue7);
	}
	@Test
	public void testPathtrue8() {
		
		String createPathTrue8=UriParserFactory.create( "https://prog2@uniSaar.de/%Aa?COOKIES").parse().getPath();
		assertEquals("/%Aa",createPathTrue8);
	}
	@Test
	public void testPathtrue9() {
		
		String createPathTrue6=UriParserFactory.create( "https://prog2@uniSaar.de/%AF?COOKIES").parse().getPath();
		assertEquals("/%AF",createPathTrue6);
	}
	@Test
	public void testPathtrue10() {
		
		String createPathTrue10=UriParserFactory.create( "https://prog2@uniSaar.de/..?COOKIES").parse().getPath();
		assertEquals("/..",createPathTrue10);
	}
	
	@Test
	public void testPathtrue11() {
		
		String createPathTrue11=UriParserFactory.create( "https://prog2@uniSaar.de/.kfh?COOKIES").parse().getPath();
		assertEquals("/.kfh",createPathTrue11);
	}
	@Test
	public void testPathtrue12() {
		
		String createPathTrue12=UriParserFactory.create( "https://prog2@uniSaar.de/?COOKIES").parse().getPath();
		assertEquals("/",createPathTrue12);
	}
	@Test
	public void testPathtrue13() {
		
		String createPathTrue13=UriParserFactory.create( "https://prog2@uniSaar.de/.?COOKIES").parse().getPath();
		assertEquals("/.",createPathTrue13);
	}
	@Test
	(expected=NullPointerException.class)
	public void testPathFalse1() {
		
		String createPathFalse1=UriParserFactory.create("https://prog2@uniSaar.de/%UI?COOKIES").parse().getPath();
		fail(createPathFalse1);
	}
	@Test
	(expected=NullPointerException.class)
	public void testPathFalse2() {
		
		String createPathFalse2=UriParserFactory.create("https://prog2@uniSaar.de/A a?COOKIES").parse().getPath();
		fail(createPathFalse2);
	}
	@Test
	(expected=NullPointerException.class)
	public void testPathFalse3() {
		
		String createPathFalse3=UriParserFactory.create("https://prog2@uniSaar.de/%FK?COOKIES").parse().getPath();
		fail(createPathFalse3);
	}
	@Test
	(expected=NullPointerException.class)
	public void testPathFalse4() {
		
		String createPathFalse4=UriParserFactory.create("https://prog2@uniSaar.de/%1?COOKIES").parse().getPath();
		fail(createPathFalse4);
	}
	@Test
	(expected=NullPointerException.class)
	public void testPathFalse5() {
		
		String createPathFalse5=UriParserFactory.create("https://prog2@uniSaar.de/%1?COOKIES").parse().getPath();
		fail(createPathFalse5);
	}
	@Test
	(expected=NullPointerException.class)
	public void testPathFalse6() {
		
		String createPathFalse6=UriParserFactory.create("https://prog2@uniSaar.de/.a_g?COOKIES").parse().getPath();
		fail(createPathFalse6);
	}
	@Test
	public void testNonNullPath() {
		String leerPath=UriParserFactory.create("schema://prog2@uniSaar.de?cookies=true").parse().getPath();
		assertEquals("",leerPath);
	}
	
	@Test
	public void testQueryTrue1(){

		String createQueryTrue1=UriParserFactory.create("https://prog2@uniSaar.de/info?cookies").parse().getQuery();
		assertEquals("cookies",createQueryTrue1);
	}
	@Test
	public void testQueryTrue2(){

		String createQueryTrue2=UriParserFactory.create("https://prog2@uniSaar.de/info?COOKIES").parse().getQuery();
		assertEquals("COOKIES",createQueryTrue2);
	}
	@Test
	public void testQueryTrue3(){

		String createQueryTrue3=UriParserFactory.create("https://prog2@uniSaar.de/info?COOkies").parse().getQuery();
		assertEquals("COOkies",createQueryTrue3);
	}
	@Test
	public void testQueryTrue4(){

		String createQueryTrue4=UriParserFactory.create("https://prog2@uniSaar.de/info?cooKIES").parse().getQuery();
		assertEquals("cooKIES",createQueryTrue4);
	}
	@Test
	public void testQueryTrue5(){

		String createQueryTrue5=UriParserFactory.create("https://prog2@uniSaar.de/info?COOK1").parse().getQuery();
		assertEquals("COOK1",createQueryTrue5);
	}
	@Test
	public void testQueryTrue6(){

		String createQueryTrue6=UriParserFactory.create("https://prog2@uniSaar.de/info?1cook").parse().getQuery();
		assertEquals("1cook",createQueryTrue6);
	}
	@Test
	public void testQueryTrue7(){

		String createQueryTrue7=UriParserFactory.create("https://prog2@uniSaar.de/info?1234").parse().getQuery();
		assertEquals("1234",createQueryTrue7);
	}
	@Test
	public void testQueryTrue8(){

		String createQueryTrue8=UriParserFactory.create("https://prog2@uniSaar.de/info?&&").parse().getQuery();
		assertEquals("&&",createQueryTrue8);
	}
	@Test
	public void testQueryTrue9(){

		String createQueryTrue9=UriParserFactory.create("https://prog2@uniSaar.de/info?==").parse().getQuery();
		assertEquals("==",createQueryTrue9);
	}
	@Test
	public void testQueryTrue10(){

		String createQueryTrue10=UriParserFactory.create("https://prog2@uniSaar.de/info?haya&khd").parse().getQuery();
		assertEquals("haya&khd",createQueryTrue10);
	}
	
	@Test
	public void testQueryTrue11(){

		String createQueryTrue11=UriParserFactory.create("https://prog2@uniSaar.de/info?haya=khd").parse().getQuery();
		assertEquals("haya=khd",createQueryTrue11);
	}
	@Test
	public void testQueryTrue12(){

		String createQueryTrue12=UriParserFactory.create("https://prog2@uniSaar.de/info?haya&123").parse().getQuery();
		assertEquals("haya&123",createQueryTrue12);
	}
	@Test
	public void testQueryTrue13(){

		String createQueryTrue13=UriParserFactory.create("https://prog2@uniSaar.de/info?haya=123").parse().getQuery();
		assertEquals("haya=123",createQueryTrue13);
	}
	@Test
	public void testQueryTrue14(){

		String createQueryTrue14=UriParserFactory.create("https://prog2@uniSaar.de/info?123&123").parse().getQuery();
		assertEquals("123&123",createQueryTrue14);
	}
	@Test
	public void testQueryTrue15(){

		String createQueryTrue15=UriParserFactory.create("https://prog2@uniSaar.de/info?123=123").parse().getQuery();
		assertEquals("123=123",createQueryTrue15);
	}
	@Test
	public void testQueryTrue16(){

		String createQueryTrue16=UriParserFactory.create("https://prog2@uniSaar.de/info?123=&123").parse().getQuery();
		assertEquals("123=&123",createQueryTrue16);
	}
	@Test
	public void testQueryTrue17(){

		String createQueryTrue17=UriParserFactory.create("https://prog2@uniSaar.de/info?haya=&123").parse().getQuery();
		assertEquals("haya=&123",createQueryTrue17);
	}
	@Test
	public void testQueryTrue18(){

		String createQueryTrue18=UriParserFactory.create("https://prog2@uniSaar.de/info?haya=&khd").parse().getQuery();
		assertEquals("haya=&khd",createQueryTrue18);
	}
	@Test
	public void testQueryTrue19(){

		String createQueryTrue19=UriParserFactory.create("https://prog2@uniSaar.de/info?haya.khd").parse().getQuery();
		assertEquals("haya.khd",createQueryTrue19);
	}
	@Test
	public void testQueryTrue20(){

		String createQueryTrue20=UriParserFactory.create("https://prog2@uniSaar.de/info?haya.1").parse().getQuery();
		assertEquals("haya.1",createQueryTrue20);
	}
	@Test
	public void testQueryTrue21(){

		String createQueryTrue21=UriParserFactory.create("https://prog2@uniSaar.de/info?123.1").parse().getQuery();
		assertEquals("123.1",createQueryTrue21);
	}
	@Test
	public void testQueryTrue22(){

		String createQueryTrue22=UriParserFactory.create("https://prog2@uniSaar.de/info?haya.=&123").parse().getQuery();
		assertEquals("haya.=&123",createQueryTrue22);
	}
	@Test
	public void testQueryTrue23(){

		String createQueryTrue23=UriParserFactory.create("https://prog2@uniSaar.de/info?haya.=&khd").parse().getQuery();
		assertEquals("haya.=&khd",createQueryTrue23);
	}
	@Test
	public void testQueryTrue24(){

		String createQueryTrue24=UriParserFactory.create("https://prog2@uniSaar.de/info?HAYA&khd").parse().getQuery();
		assertEquals("HAYA&khd",createQueryTrue24);
	}
	@Test
	public void testQueryTrue25(){

		String createQueryTrue10=UriParserFactory.create("https://prog2@uniSaar.de/info?HAYA&").parse().getQuery();
		assertEquals("HAYA&",createQueryTrue10);
	}
	@Test
	public void testQueryTrue26(){

		String createQueryTrue26=UriParserFactory.create("https://prog2@uniSaar.de/info?HAYA=").parse().getQuery();
		assertEquals("HAYA=",createQueryTrue26);
	}
	@Test
	public void testQueryTrue27(){

		String createQueryTrue27=UriParserFactory.create("https://prog2@uniSaar.de/info?&%AF").parse().getQuery();
		assertEquals("&%AF",createQueryTrue27);
	}
	@Test
	public void testQueryTrue28(){

		String createQueryTrue28=UriParserFactory.create("https://prog2@uniSaar.de/info?=%Af").parse().getQuery();
		assertEquals("=%Af",createQueryTrue28);
	}
	@Test
	(expected=NullPointerException.class)
	public void testQueryFalse1() {
		String createQueryFalse1= UriParserFactory.create("https://prog2@uniSaar.de/info?cookies-false").parse().getQuery();
		fail(createQueryFalse1);
	}
    @Test
    (expected=NullPointerException.class)
	public void testQueryFalse2() {
		String createQueryFalse2= UriParserFactory.create("https://prog2@uniSaar.de/info?%UI").parse().getQuery();
		fail(createQueryFalse2);
	}
    @Test
    (expected=NullPointerException.class)
   	public void testQueryFalse3() {
   		String createQueryFalse3= UriParserFactory.create("https://prog2@uniSaar.de/info?%U").parse().getQuery();
   		fail(createQueryFalse3);
   	}
    @Test
    (expected=NullPointerException.class)
   	public void testQueryFalse4() {
   		String createQueryFalse4= UriParserFactory.create("https://prog2@uniSaar.de/info?%UIJ").parse().getQuery();
        fail(createQueryFalse4);
   	}
    @Test
    (expected=NullPointerException.class)
   	public void testQueryFalse5() {
   		String createQueryFalse5= UriParserFactory.create("https://prog2@uniSaar.de/info?A_F").parse().getQuery();
   		fail(createQueryFalse5);
   	}
    @Test
    (expected=NullPointerException.class)
	public void testQueryFalse6() {
		String createQueryFalse6= UriParserFactory.create("https://prog2@uniSaar.de/info?U I").parse().getQuery();
		fail(createQueryFalse6);
	}
    @Test
    (expected=NullPointerException.class)
	public void testQueryFalse7() {
		String createQueryFalse7= UriParserFactory.create("https://prog2@uniSaar.de/info?%123").parse().getQuery();
		fail(createQueryFalse7);
    }
	@Test
	public void testNonNullQuery() {
		String leerQuery=UriParserFactory.create("schema://prog2@uniSaar.de/info?").parse().getQuery();
		assertEquals("",leerQuery);
	}
	
	
	/*Host*/
	@Test
	
	public void testregNameTrue1() {
		String regName1=UriParserFactory.create("schema://prog2@%aa/info?cookies=true").parse().getHost().toString();
		assertEquals("%aa",regName1);
	}
    @Test
	public void testregNameTrue2() {
		String regName2=UriParserFactory.create("schema://prog2@%Ab/info?cookies=true").parse().getHost().toString();
		assertEquals("%Ab",regName2);
	}
    @Test

    public void testregNameTrue3() {
	   String regName3=UriParserFactory.create("schema://prog2@%12/info?cookies=true").parse().getHost().toString();
	   assertEquals("%12",regName3);
}
    @Test
    public void testregNameTrue4() {
	   String regName4=UriParserFactory.create("schema://prog2@%1a/info?cookies=true").parse().getHost().toString();
	   assertEquals("%1a",regName4);
}
    @Test
    public void testregNameTrue5() {
	   String regName5=UriParserFactory.create("schema://prog2@%3A/info?cookies=true").parse().getHost().toString();
	   assertEquals("%3A",regName5);
}

    @Test
    public void testregNameTrue6() {
	   String regName6=UriParserFactory.create("schema://prog2@%CC/info?cookies=true").parse().getHost().toString();
	   assertEquals("%CC",regName6);
}
    @Test
    public void testregNameTrue7() {
		String regName7=UriParserFactory.create("schema://prog2@%F7/info?cookies=true").parse().getHost().toString();
		assertEquals("%F7",regName7);
}
	
    @Test
    (expected=NullPointerException.class)
	public void testregNameFalse1() {
		String regNameFalse1=UriParserFactory.create("schema://prog2@%Ha/info?cookies=true").parse().getHost().toString();
		fail(regNameFalse1);
}
    @Test
    (expected=NullPointerException.class)
	public void testregNameFalse2() {
		String regNameFalse2=UriParserFactory.create("schema://prog2@%M7/info?cookies=true").parse().getHost().toString();
		fail(regNameFalse2);
}
    @Test
    (expected=NullPointerException.class)
	public void testregNameFalse3() {
		String regNameFalse3=UriParserFactory.create("schema://prog2@%HaY/info?cookies=true").parse().getHost().toString();
		fail(regNameFalse3);
}
    @Test
    (expected=NullPointerException.class)
	public void testregNameFalse4() {
		String regNameFalse4=UriParserFactory.create("schema://prog2@%c/info?cookies=true").parse().getHost().toString();
		fail(regNameFalse4);
}
    @Test
    (expected=NullPointerException.class)
	public void testregNameFalse5() {
		String regNameFalse5=UriParserFactory.create("schema://prog2@%F/info?cookies=true").parse().getHost().toString();
		fail(regNameFalse5);
}
    @Test
    (expected=NullPointerException.class)
	public void testregNameFalse6() {
		String regNameFalse6=UriParserFactory.create("schema://prog2@%1/info?cookies=true").parse().getHost().toString();
		fail(regNameFalse6);
}
    @Test
    (expected=NullPointerException.class)
	public void testregNameFalse7() {
		String regNameFalse7=UriParserFactory.create("schema://prog2@%-9/info?cookies=true").parse().getHost().toString();
		fail(regNameFalse7);
}
    @Test
    public void testDecOctetTrue1() {
    	Host DecOctetTrue1=UriParserFactory.create("schema://prog2@001.010.100.212/info?cookies=true").parse().getHost();
    	assertTrue(isIPv4Address(DecOctetTrue1));
    }
    @Test
    public void testDecOctetTrue2() {
    	Host DecOctetTrue2=UriParserFactory.create("schema://prog2@200.250.255.001/info?cookies=true").parse().getHost();
    	assertTrue(isIPv4Address(DecOctetTrue2));
    }
    @Test
    public void testDecOctetTrue3() {
    	Host DecOctetTrue3=UriParserFactory.create("schema://prog2@200.250.001.010/info?cookies=true").parse().getHost();
    	assertTrue(isIPv4Address(DecOctetTrue3));
    }
    @Test
    public void testDecOctetFalse1() {
    	Host DecOctetFalse1=UriParserFactory.create("schema://prog2@279.267.256.765/info?cookies=true").parse().getHost();
    	assertFalse(isIPv4Address(DecOctetFalse1));
    }
    @Test
    public void testDecOctetFalse2() {
    	Host DecOctetFalse2=UriParserFactory.create("schema://prog2@0.1.100.7/info?cookies=true").parse().getHost();
    	assertFalse(isIPv4Address(DecOctetFalse2));
    }    
    @Test
    public void testDecOctetFalse3() {
       Host DecOctetFalse3=UriParserFactory.create("schema://prog2@3a.100.8/info?cookies=true").parse().getHost();
       assertFalse(isIPv4Address(DecOctetFalse3));
    }
	@Test
	public void testNonNullHost() {
		String leerHost=UriParserFactory.create("https://prog2").parse().getHost().toString();
		assertEquals("",leerHost);
	}
	}

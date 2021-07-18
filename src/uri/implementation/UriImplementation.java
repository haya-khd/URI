package uri.implementation;

import uri.Host;
import uri.Uri;

// TODO implement this class or another implementation of Uri
public class UriImplementation implements Uri {

	  public String Test;
	  
	public UriImplementation(String haya) {
		this.Test= haya; 
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getScheme() {
		// TODO implement this
		
		if(!(Test.contains("://"))) {
			return null;
		}
		String[] Schema= Test.split("://");
		if(Schema[0].matches("[A-Za-z]([A-Za-z0-9])*")) {
			return Schema[0];
		}
		else {
			throw new NullPointerException();
	}
	}

	@Override
	public String getQuery() {
		// TODO implement this
		if(!Test.contains("?")) {
			return null;
		}
		else {
		String[] Query=Test.split("\\?");
		if(Query[1].matches("([A-Za-z0-9.&=]|[%][A-Fa-f0-9][A-Fa-f0-9])*")) {
			return Query[1];
		}
		else {
		throw new NullPointerException();
	}
		}
	}

	@Override
	public String getUserInfo() {
		// TODO implement this
		if(!Test.contains("@")) {
			return "";
		}
		else {
		String[] UserInfo1=Test.split("\\://");
		String[] UserInfo2=UserInfo1[1].split("\\@");
		if(UserInfo2[0].matches("([A-Za-z0-9:]|[%][A-Fa-f0-9][A-Fa-f0-9])*")) {
			return UserInfo2[0];
		}
		else {
		throw  new NullPointerException();
	}	
	}
	}

	@Override
	public Host getHost() {
		String[] Test2=Test.split("\\://");
		int count=0;
		if(Test2[1]==null) {
			return null;
		}else {
		//@ -> /
		if(Test2[1].contains("@")) {
		if(Test2[1].contains("/")) {
		String[] a=Test2[1].split("@");
		String[] b=a[1].split("/");	
		char toCheck= '.';
	    for (char ch: b[0].toCharArray()) { 
	        if (ch == toCheck) {
	            count++;
	        }
	    }
	    if(count==4) {
	    String[] cc=b[0].split("\\.");
		String bb="";
			    if(cc.length==4){
			    for(int i=0; i<4; i++){
			    if(!b[0].matches("(0*[0-9]|0*[1-9][0-9]|[1][0-9][0-9]|[2][0-4][0-9]|[2][5][0-5])")) {
					bb+="false";
}
				else {bb+="true";}		
}
			    if(!bb.contains("false")) {
			    return new HostImplementation(b[0]);
}
}
			    }
				 else
{
				 if(b[0].matches("([A-Za-z0-9.]|[%][A-Fa-f0-9][A-Fa-f0-9])*")) {
					return new HostImplementation(b[0]);
				}
				else{
				throw new NullPointerException();}
}
}			    
	   else {
		   if(Test2[1].contains("?")) {
		   String[] a  =Test2[1].split("@");
		   String[] b  =a[1].split("?");
			char toCheck= '.';
		    for (char ch: b[0].toCharArray()) { 
		        if (ch == toCheck) {
		            count++;
		        }
		    }
		    if(count==4) {
		    String[] cc=b[0].split("\\.");
			String bb="";
				    if(cc.length==4){
				    for(int i=0; i<4; i++){
				    if(!b[0].matches("(0*[0-9]|0*[1-9][0-9]|[1][0-9][0-9]|[2][0-4][0-9]|[2][5][0-5])")) {
						bb+="false";
	}
					else {bb+="true";}		
	}
				    if(!bb.contains("false")) {
				    return new HostImplementation(b[0]);
	}
	}
   }	    
		    
					 else
	{
					 if(b[0].matches("([A-Za-z0-9.]|[%][A-Fa-f0-9][A-Fa-f0-9])*")) {
						return new HostImplementation(b[0]);
					}
					else{
					throw new NullPointerException();}
	}
		   
	           }
		   else {
			   String[] a =Test2[1].split("@");
				char toCheck= '.';
			    for (char ch: a[1].toCharArray()) { 
			        if (ch == toCheck) {
			            count++;
			        }
			    }
			    if(count==4) {
			    String[] cc=a[1].split("\\.");
				String bb="";
					    if(cc.length==4){
					    for(int i=0; i<4; i++){
					    if(!a[1].matches("(0*[0-9]|0*[1-9][0-9]|[1][0-9][0-9]|[2][0-4][0-9]|[2][5][0-5])")) {
							bb+="false";
		}
						else {bb+="true";}		
		}
					    if(!bb.contains("false")) {
					    return new HostImplementation(a[1]);
		}
		}
			    }
						 else
		{
						 if(a[1].matches("([A-Za-z0-9.]|[%][A-Fa-f0-9][A-Fa-f0-9])*")) {
							return new HostImplementation(a[1]);
						}
						else{
						throw new NullPointerException();}
		}
			   
		   }
	   }
		}
		else {
			if(Test2[1].contains("/")) {
				String[] a= Test2[1].split("/");
				char toCheck= '.';
			    for (char ch: a[1].toCharArray()) { 
			        if (ch == toCheck) {
			            count++;
			        }
			    }
			    if(count==4) {
			    String[] cc=a[1].split("\\.");
						String bb="";
							    if(cc.length==4){
							    for(int i=0; i<4; i++){
							    if(!a[1].matches("(0*[0-9]|0*[1-9][0-9]|[1][0-9][0-9]|[2][0-4][0-9]|[2][5][0-5])")) {
									bb+="false";
				}
								else {bb+="true";}		
				}
							    if(!bb.contains("false")) {
							    return new HostImplementation(a[1]);
				}
				}
			    }
								 else
				{
								 if(a[1].matches("([A-Za-z0-9.]|[%][A-Fa-f0-9][A-Fa-f0-9])*")) {
									return new HostImplementation(a[1]);
								}
								else{
								throw new NullPointerException();}
			}
			}
			else {
				if(Test2[1].contains("?")) {
					String[] a= Test2[1].split("?");
					char toCheck= '.';
				    for (char ch: a[1].toCharArray()) { 
				        if (ch == toCheck) {
				            count++;
				        }
				    }
				    if(count==4) {
				    String[] cc=a[1].split("\\.");
							String bb="";
								    if(cc.length==4){
								    for(int i=0; i<4; i++){
								    if(!a[1].matches("(0*[0-9]|0*[1-9][0-9]|[1][0-9][0-9]|[2][0-4][0-9]|[2][5][0-5])")) {
										bb+="false";
					}
									else {bb+="true";}		
					}
								    if(!bb.contains("false")) {
								    return new HostImplementation(a[1]);
					}
					}
				    }
									 else
					{
									 if(a[1].matches("([A-Za-z0-9.]|[%][A-Fa-f0-9][A-Fa-f0-9])*")) {
										return new HostImplementation(a[1]);
									}
									else{
									throw new NullPointerException();}
				}
				}
			
			}
		}
		}
		return new HostImplementation(Test2[1]);
		}
	
	

	@Override
	public String getPath() {

		// TODO implement this
		String[] ah=Test.split("\\://");
		if (!ah[1].contains("/")) {
		return "";
		}
		else {

		if (Test.contains("@")) {
			if(Test.contains("?")) {
			
		    String[] a=Test.split("\\://");
			String[] b=a[1].split("\\@");
			String[] c=b[1].split("\\?");
			String[] d=c[0].split("\\/");
			if(d[1].matches("([A-Za-z0-9.]|[%][A-Fa-f0-9][A-Fa-f0-9])*")) {
				
				return ("/"+ d[1]);
			}
			else {
				throw  new NullPointerException();
			}
			}
			else
			{
		    String[] a =Test.split("\\://");
			String[] b=a[1].split("\\@");
			String[] c=b[1].split("\\/");
			if(c[1].matches("([A-Za-z0-9.]|[%][A-Fa-f0-9][A-Fa-f0-9])*")) {
				return ("/"+ c[1]);
			}
			else {
				throw  new NullPointerException();
			}
		}
		}
		else {
			if(Test.contains("?")) {
				
			String[] a=Test.split("\\://");
			String[] b=a[1].split("\\?");
			String[] c=b[0].split("\\/");
			if(c[1].matches("([A-Za-z0-9.]|[%][A-Fa-f0-9][A-Fa-f0-9])*")) {
				return ("/"+ c[1]);
			}
			else {
				throw  new NullPointerException();
			}
			}
		else {
			String[] aa=Test.split("\\://");
			String[] bb=aa[1].split("\\/");
			if(bb[1].matches("([A-Za-z0-9.]|[%][A-Fa-f0-9][A-Fa-f0-9])*")) {
				return ("/"+ bb[1]);
		}
			else {
				throw  new NullPointerException();
			}
		}
		}
		
	}
	}
	}


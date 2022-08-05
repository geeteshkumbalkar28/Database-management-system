 import java.lang.*;
 import java.util.*;
 
 //create table student(RollNo int,Name varchar(225),Address varchar(225),Marks int);
 //Database table / schema
 
 class Student
 {
	 public int RollNo;
	 public String Name;
	 public String Address;
	 public int Marks;
	 
	 private static int Generator;
	
	static 
	{
		Generator=0;
	}
	 public Student(String str,String str2,int value)
	 {
		 this.RollNo=++Generator;
		 this.Name=str;
		 this.Address=str2;
		 this.Marks=value;
	 }
	 public void DisplayData()
	 { 
	

			
		
	 
		 System.out.println("|\t  "+this.RollNo+"\t\t|\t"+this.Name+"\t|\t "+this.Address+" \t|\t"+this.Marks+"\t|");
		 
		 System.out.println("---------------------------------------------------------------------------------");
		 
	 }
 }
 class DBMS
 {
	public LinkedList <Student> lobj;
	
	public DBMS()
	{
		lobj =new LinkedList<>();
	}
	 public void StartDBMS()
	 {
		 Scanner scanobj=new Scanner(System.in);
		 
		System.out.println("Customised DBMS started Succesfully...");
		String Query="";
	
		while(true)
		{
			System.out.print("DBMS console =>");
			Query=scanobj.nextLine();
			
			String tokens[]=Query.split(" ");
			int QuerySize=tokens.length;
			
			for(int i=0; i<tokens.length;i++)
			{
				System.out.println(tokens[i]);
			}

			if(QuerySize==1)
			{
				
				if("Help".equals(tokens[0]))
				{
					
					System.out.println("This application is used to demonstrates the customised DBMS");
					System.out.println("     Exit         : Terminate DBMS");
					System.out.println("     Man          : To show the Description and how to use query (how to use query type 2time Man Man)");
					System.out.println("    Select        : To Select the table");
					System.out.println("    Insert   	  : Insert into student Name Address Marks");
					System.out.println("    delete	      : Delete the data");
					System.out.println();
				}
				else if("Exit".equals(tokens[0]))
				{
					System.out.println("Thank you for using DBMS");
					break;
				}
				else
				{
					
					System.out.println("Query not found ....!!!");
					System.out.println();
				}
		
				
			}
			else if(QuerySize==2)
			{
				if("Man".equals(tokens[0]))
				{
					Man(tokens[1]);
				}
				else
				{
				
					System.out.println("Query not found ....!!!");
					System.out.println();
				}
		
			}
			
			else if(QuerySize == 4)
			{
				//Select * from student
				if(("Select".equals(tokens[0]))&&("*".equals(tokens[1])))
				{
					if("*".equals(tokens[1]))
					{
						if("from".equals(tokens[2]))
						{
							if("student".equals(tokens[3]))
							{
								
								DisplayAll();
							}
						}
					}
				}
				
			
				//Select MIN(Marks) from student
				else if(("Select".equals(tokens[0]))&&("MIN(Marks)".equals(tokens[1])))
				{
					 if("MIN(Marks)".equals(tokens[1]))
					{
						if("from".equals(tokens[2]))
						{
							if("student".equals(tokens[3]))
							{
								
								AggregateMinMarks();
						
							}
						}
					}
				}	
					//Select MAX(Marks) from student
				else if(("Select".equals(tokens[0]))&&("MAX(Marks)".equals(tokens[1])))
				{
					 if("MAX(Marks)".equals(tokens[1]))
					{
						if("from".equals(tokens[2]))
						{
							if("student".equals(tokens[3]))
							{
								
								AggregateMaxMarks();
					
							}
						}
					}
				}
					//Select AVG(Marks) from student
				else if(("Select".equals(tokens[0]))&&("AVG(Marks)".equals(tokens[1])))
				{ 
					if("AVG(Marks)".equals(tokens[1]))
					{
						if("from".equals(tokens[2]))
						{
							if("student".equals(tokens[3]))
							{
								AggregateAvg();
					
							}
						}
					}

				}	
				//Select SUM(Marks) from student
				else if(("Select".equals(tokens[0]))&&("SUM(Marks)".equals(tokens[1])))
				{
				
					 if("SUM(Marks)".equals(tokens[1]))
					{
						if("from".equals(tokens[2]))
						{
							if("student".equals(tokens[3]))
							{
								SumOfMark();
							}
						}
					}
				}
			
				//delete * from student
				else if(("delete".equals(tokens[0]))&&("*".equals(tokens[1])))
				{
					if("*".equals(tokens[1]))
					{
						if("from".equals(tokens[2]))
						{
							if("student".equals(tokens[3]))
							{
								DeleteAll();
								System.out.println("Delete All data succesfully");
							}
						}
					}
				}
				else 
				{
					System.out.println("ERROR : Check the query");
				}
			}
			else if(QuerySize == 6)
			{
				// Insert into student Name Address Marks ;
				if("Insert".equals(tokens[0]))
				{
					if("into".equals(tokens[1]))
					{
						if("student".equals(tokens[2]))
						{
							byte byteArray[]= tokens[5].getBytes();
					
							if(('0' == (char)byteArray[0])||('1' == (char)byteArray[0])||('2' == (char)byteArray[0])||('3' == (char)byteArray[0])||('4' == (char)byteArray[0])||('5' == (char)byteArray[0])||('6' == (char)byteArray[0])||('7' == (char)byteArray[0])||('8' == (char)byteArray[0])||('9' == (char)byteArray[0]))
							{
								InsertData(tokens[3],tokens[4],Integer.parseInt(tokens[5]));
								System.out.println(" your Data is Succesfully Insert");
							}
							else
							{
								 System.out.println("Enter the marks in digit ");
							}
							
						}
						else
						{
								System.out.println("ERROR : 'student' is missing from your query");
							
						}
					}
					else
					{
								System.out.println("ERROR : 'into' is missing from your query");
					
					}
				}
				else
				{
				
								System.out.println("ERROR : 'Insert' is missing from your query");

				}				
			}
			else if(QuerySize == 7)
			{
				//Select * from student Order by Name
				if(("Select".equals(tokens[0]))&&("Name".equals(tokens[6])))
				{
					if("*".equals(tokens[1]))
					{
						if("from".equals(tokens[2]))
						{
							if("student".equals(tokens[3]))
							{
								if("Order".equals(tokens[4]))
								{
									if("by".equals(tokens[5]))
									{
										if("Name".equals(tokens[6]))
										{
											
											DisplayOrderByName();
											
										}
									}
								}
							}
						}
					}	
				}
				//delete from student where rollno = RollNo(Ex. 11)
				else if(("delete".equals(tokens[0]))&&("rollno".equals(tokens[4])))
				{
					if("from".equals(tokens[1]))
					{
						if("student".equals(tokens[2]))
						{
							if("where".equals(tokens[3]))
							{
								if("rollno".equals(tokens[4]))
								{
									if("=".equals(tokens[5]))
									{
										byte byteArray[] = tokens[6].getBytes();
					
										if(('0' == (char)byteArray[0])||('1' == (char)byteArray[0])||('2' == (char)byteArray[0])||('3' == (char)byteArray[0])||('4' == (char)byteArray[0])||('5' == (char)byteArray[0])||('6' == (char)byteArray[0])||('7' == (char)byteArray[0])||('8' == (char)byteArray[0])||('9' == (char)byteArray[0]))
										{
											DeleteSpecific(Integer.parseInt(tokens[6]));
											
											System.out.println("Delete data succesfully");
										}
										else
										{
											
											System.out.println("Enter the roll no in digit ");
										}
										
									}
								}
							}
						}
					}
				}	
				//delete from student where marks = Marks(Ex. 90)
				else if(("delete".equals(tokens[0]))&&("marks".equals(tokens[4])))
				{
					if("from".equals(tokens[1]))
					{
						if("student".equals(tokens[2]))
						{
							if("where".equals(tokens[3]))
							{
								if("marks".equals(tokens[4]))
								{
									if("=".equals(tokens[5]))
									{
										byte byteArray[] = tokens[6].getBytes();
					
										if(('0' == (char)byteArray[0])||('1' == (char)byteArray[0])||('2' == (char)byteArray[0])||('3' == (char)byteArray[0])||('4' == (char)byteArray[0])||('5' == (char)byteArray[0])||('6' == (char)byteArray[0])||('7' == (char)byteArray[0])||('8' == (char)byteArray[0])||('9' == (char)byteArray[0]))
											{
												
											
												Deletespecific(Integer.parseInt(tokens[6]));
												
												System.out.println("Delete data succesfully");
											}
											else
											{
												System.out.println("Enter the marks in digit ");
											}
									}
								}
							}
						}
					}
				}
				else
				{
				
					System.out.println("ERROR : Check the query");

				}					
			}
			else if(QuerySize == 8)
			{
				//Select * from student where rollno = RollNo
				if(("Select".equals(tokens[0]))&&"rollno".equals(tokens[5])&&("=".equals(tokens[6])))
				{
					if("*".equals(tokens[1]))
					{
						if("from".equals(tokens[2]))
						{
							if("student".equals(tokens[3]))
							{
								if("where".equals(tokens[4]))
								{
									
									if("rollno".equals(tokens[5]))
									{
										if("=".equals(tokens[6]))
										{
											byte byteArray[] = tokens[7].getBytes();
						
											if(('0' == (char)byteArray[0])||('1' == (char)byteArray[0])||('2' == (char)byteArray[0])||('3' == (char)byteArray[0])||('4' == (char)byteArray[0])||('5' == (char)byteArray[0])||('6' == (char)byteArray[0])||('7' == (char)byteArray[0])||('8' == (char)byteArray[0])||('9' == (char)byteArray[0]))
											{	
												
													DisplaySpecific(Integer.parseInt(tokens[7]));
												
											}
											else
											{
												System.out.println("Enter the marks in digit ");
											}
										}
									}
								}
								
							}
						}
					}
										
				}
				//Select * from student where name = Name
				else if(("Select".equals(tokens[0]))&&("name".equals(tokens[5])))
				{
					if("*".equals(tokens[1]))
					{
						if("from".equals(tokens[2]))
						{
							if("student".equals(tokens[3]))
							{
								if("where".equals(tokens[4]))
								{
									if("name".equals(tokens[5]))
									{
										if("=".equals(tokens[6]))
										{
											DisplaySpecific(tokens[7]);
										}
									}
								}
							}
						}
					}
				}
				//Select * from student where mark = Marks
				else if(("Select".equals(tokens[0]))&&("mark".equals(tokens[5])))
				{
					if("*".equals(tokens[1]))
					{
						if("from".equals(tokens[2]))
						{
							if("student".equals(tokens[3]))
							{
								if("where".equals(tokens[4]))
								{
									if("mark".equals(tokens[5]))
									{
										if("=".equals(tokens[6]))
										{
											byte byteArray[] = tokens[7].getBytes();
						
											if(('0' == (char)byteArray[0])||('1' == (char)byteArray[0])||('2' == (char)byteArray[0])||('3' == (char)byteArray[0])||('4' == (char)byteArray[0])||('5' == (char)byteArray[0])||('6' == (char)byteArray[0])||('7' == (char)byteArray[0])||('8' == (char)byteArray[0])||('9' == (char)byteArray[0]))
											{	
												
													DisplaySpecific(Integer.parseInt(tokens[7]));
												
											}
											else
											{
												System.out.println("Enter the rollno in digit ");
											}
										}
									}
								}
							}
						}
					}
										
				}
				//Select * from student where address = Address
				else if(("Select".equals(tokens[0]))&&("address".equals(tokens[5])))
				{
					if("*".equals(tokens[1]))
					{
						if("from".equals(tokens[2]))
						{
							if("student".equals(tokens[3]))
							{
								if("where".equals(tokens[4]))
								{
									if("address".equals(tokens[5]))
									{
										if("=".equals(tokens[6]))
										{
											DisplaySpecific(tokens[7]);
										}
									}
								}
							}
						}
					}
				
				} 
				// Select COUNT(Name) from Student where Marks > Marks
				else if(("Select".equals(tokens[0]))&&("COUNT(Name)".equals(tokens[1])))
				{
					if("COUNT(Name)".equals(tokens[1]))
					{
						if("from".equals(tokens[2]))
						{
							if("Student".equals(tokens[3]))
							{
								if("where".equals(tokens[4]))
								{
						
									
									if("Marks".equals(tokens[5]))
									{
										System.out.println("inside >");
											
										if(">".equals(tokens[6]))
										{
											byte byteArray[] = tokens[7].getBytes();
						
											if(('0' == (char)byteArray[0])||('1' == (char)byteArray[0])||('2' == (char)byteArray[0])||('3' == (char)byteArray[0])||('4' == (char)byteArray[0])||('5' == (char)byteArray[0])||('6' == (char)byteArray[0])||('7' == (char)byteArray[0])||('8' == (char)byteArray[0])||('9' == (char)byteArray[0]))
											{	
							
												CountByMark(Integer.parseInt(tokens[7]));
												
											}
											else
											{
												System.out.println("Enter the marks in digit ");
											}
										}
									}
								}
							}
						}
					}
				}
				// Select Name from student where Name like 'A%'
				// Select Name from student where Name like 'A__'
				else if(("Select".equals(tokens[0]))&&("like".equals(tokens[6])))
				{
					if("Name".equals(tokens[1]))
					{
						if("from".equals(tokens[2]))
						{System.out.println("Inside where");
							if("student".equals(tokens[3]))
							{
								if("where".equals(tokens[4]))
								{
						
									if("Name".equals(tokens[5]))
									{
										if("like".equals(tokens[6]))
										{
																
											byte byteArray[]= tokens[7].getBytes();
											
											
										
											if('%' == (char)byteArray[2])
											{
												
										System.out.println("inside %");
												Matching(byteArray[1]);
											}
											else if('_'==((char)byteArray[2]))
											{		
												int iCnt=0;
												for(int i=0;i<byteArray.length;i++)
												{
													if((char)byteArray[i]=='_')
													{
														iCnt++;
													}
													
												}
												Matching(byteArray[1],iCnt);
												
											}

										}
									}
								}
							}
						}
					}
				}	
				else
				{
				
					System.out.println("ERROR : Check the query");

				}	
			}
			else if(QuerySize == 9)
			{
				//Select count(RollNo) , Address from Student Group by Address 
				if("Select".equals(tokens[0]))
				{
					if("count(RollNo)".equals(tokens[1]))
					{
						if(",".equals(tokens[2]))
						{
							if("Address".equals(tokens[3]))
							{
								if("from".equals(tokens[4]))
								{
									if("Student".equals(tokens[5]))
									{
										if("Group".equals(tokens[6]))
										{
											if("by".equals(tokens[7]))
											{
												if("Address".equals(tokens[8]))
												{
														
													DisplayGrpByAddress();
												}
												else
												{
													System.out.println("ERROR : 'Address' is missing from your query");
												}
												
											}
											else
											{
												System.out.println("ERROR : 'by' is missing from your query");
											}
										}
										
										else
										{
											System.out.println("ERROR : 'Group' is missing from your query");
										}
									}
									else
									{
										System.out.println("ERROR : 'Student' is missing from your query");
									}
								}
								else
								{
									System.out.println("ERROR : 'from' is missing from your query");
								}
							}
							else
							{
								System.out.println("ERROR : 'Address' is missing from your query");
							}
						}
						else
						{
							System.out.println("ERROR : ',' is missing from your query");
						}
					}
					else
					{
						System.out.println("ERROR : 'count(RollNo)' is missing from your query");
					}
					
				}
				else
				{
				
					System.out.println("ERROR : Check the query");

				}
			}
			
			else if(QuerySize == 10)
			{
							
			//Select Name from student where Marks Between Marks(EX. 85) and Marks(EX. 95)
			if(("Select".equals(tokens[0]))&&("Between".equals(tokens[6])))
			{
				if("Name".equals(tokens[1]))
				{
					if("from".equals(tokens[2]))
					{
						if("student".equals(tokens[3]))
						{
							if("where".equals(tokens[4]))
							{
								if("Marks".equals(tokens[5]))
								{
									if("Between".equals(tokens[6]))
									{
										
										byte byteArray[]= tokens[7].getBytes();
										byte byteArra[]= tokens[9].getBytes();

										
										if((('0' == (char)byteArray[0])||('1' == (char)byteArray[0])||('2' == (char)byteArray[0])||('3' == (char)byteArray[0])||('4' == (char)byteArray[0])||('5' == (char)byteArray[0])||('6' == (char)byteArray[0])||('7' == (char)byteArray[0])||('8' == (char)byteArray[0])||('9' == (char)byteArray[0]))&&(('0' == (char)byteArra[0])||('1' == (char)byteArra[0])||('2' == (char)byteArra[0])||('3' == (char)byteArra[0])||('4' == (char)byteArra[0])||('5' == (char)byteArra[0])||('6' == (char)byteArra[0])||('7' == (char)byteArra[0])||('8' == (char)byteArra[0])||('9' == (char)byteArra[0])))
										{
											
											DisplayRange((Integer.parseInt(tokens[7])),(Integer.parseInt(tokens[9])));
										}
										else
										{
											System.out.println("Enter the marks in digit ");
										}
										

									}
									else
									{
										System.out.println("ERROR : 'Between' is missing from your query");
									}
								}
								else
								{
										System.out.println("ERROR : 'Marks' is missing from your query");
							
								}
							}
							else
							{
									System.out.println("ERROR : 'where' is missing from your query");
							
							}

						}
						
						else
						{
									System.out.println("ERROR : 'student' is missing from your query");	
									
						}

					}
					else
					{
							System.out.println("ERROR : 'from' is missing from your query");
							
					}

				}
				
				else
				{
						System.out.println("ERROR : 'Name' is missing from your query");
							
				}

			}
			else
			{
				
				System.out.println("ERROR : Check the query");

			}
			}
			else if(QuerySize == 12)
			{
				//Select * from student where marks > Marks(Ex. 90) and address = Address(Ex. Mumbai)
				if(("Select".equals(tokens[0]))&&(">".equals(tokens[6])))
				{
					if("*".equals(tokens[1]))
					{
						if("from".equals(tokens[2]))
						{
							if("student".equals(tokens[3]))
							{
								if("where".equals(tokens[4]))
								{
									if("marks".equals(tokens[5]))
									{
										if(">".equals(tokens[6]))
										{
												if("and".equals(tokens[8]))
												{
													if("address".equals(tokens[9]))
													{
														if("=".equals(tokens[10]))
														{
																byte byteArray[] = tokens[7].getBytes();
											
																if(('0' == (char)byteArray[0])||('1' == (char)byteArray[0])||('2' == (char)byteArray[0])||('3' == (char)byteArray[0])||('4' == (char)byteArray[0])||('5' == (char)byteArray[0])||('6' == (char)byteArray[0])||('7' == (char)byteArray[0])||('8' == (char)byteArray[0])||('9' == (char)byteArray[0]))
																{	
																	
																DisplaySpecific((Integer.parseInt(tokens[7])),(tokens[11]));
																	
																}
																else
																{	
																	System.out.println("Enter the marks in digit ");
																}
																
															
														}
													}
												}
											}
										
									}
								}
							}
						}
					}
				
					//Select Name form student where Address in (' Adress(Ex. pune) ',' Adress(Ex. mumbai) ')
					else if(("Select".equals(tokens[0]))&&("','".equals(tokens[9])))
					{
						if("Name".equals(tokens[1]))
						{
							if("from".equals(tokens[2]))
							{
								if("student".equals(tokens[3]))
								{
									if("where".equals(tokens[4]))
									{
										if("Address".equals(tokens[5]))
										{
											if("in".equals(tokens[6]))
											{
												if("('".equals(tokens[7]))
												{
													if("','".equals(tokens[9]))
													{
														if("')".equals(tokens[11]))
														{
																
															DisplayNameByAddrres(tokens[8],tokens[10]);		
				
														}
													}
												}
												}
											}
										}
									}
								}
							}
						}
					else
					{
				
						System.out.println("ERROR : Check the query");

					}
			}
				
			}
			else 
			{
							
					System.out.println("Query not found ....!!!");
					System.out.println();
			}
				
		
		
		}//while loop end
	 }	 
	 //To show the Description and how to use query
	 public void Man(String name)
	 {
		 if(name == null)
		 {
			 return;
		 }
		else if("Select".equals(name))
		{
			System.out.println("Description : Use to Display all Student Name Address Marks");
			System.out.println("Query       : Select * from student");
			System.out.println();
			System.out.println("Description : That Query is Use to Display Student Name Address Marks by rollno ");
			System.out.println("Query       : Select * from student where rollno = RollNo(Ex. 2)");
			System.out.println();
			System.out.println("Description : That Query is Use to Display Student Name Address Marks by Name");
			System.out.println("Query       : Select * from student where name = Name(Ex.Rohan)");
			System.out.println();
			System.out.println("Description : That Query is Use to Display Student Name Address Marks by Marks");
			System.out.println("Query       : Select * from student where mark = Marks(Ex. 90)");
			System.out.println();
			System.out.println("Description : That Query is Use to Display Student Name Address Marks by Address");
			System.out.println("Query       : Select * from student where address = Address(Ex. Mumbai)");
			System.out.println();
			System.out.println("Description : That Query is Use to Display Student Name Address Marks by Address nad mark");
			System.out.println("Query       : Select * from student where marks > Marks(Ex. 90) and address = Address(Ex. Mumbai)");
			System.out.println();
			System.out.println("Description : That Query is Use to Display Student Minmum Marks");
			System.out.println("Query       : Select MIN(Marks) from student");
			System.out.println();
			System.out.println("Description : That Query is Use to Display Student Maximum Marks");
			System.out.println("Query       : Select MAX(Marks) from student");
			System.out.println();
			System.out.println("Description : That Query is Use to Display Count No");
			System.out.println("Query       : Select COUNT(Name) from Student where Marks > Marks(Ex. 90)");
			System.out.println();
			System.out.println("Description : That Query is Use to Display Student Average by marks");
			System.out.println("Query       : Select AVG(Marks) from student");
			System.out.println();
			System.out.println("Description : That Query is Use to Display Student Average by marks");
			System.out.println("Query       : Select SUM(Marks) from student");
			System.out.println();
			System.out.println("Description : That Query is Use to Display Student Name by Character ");
			System.out.println("Query       : Select Name from student where Name like 'A%' ");
			System.out.println();
			System.out.println("Description : That Query is Use to Display Student Name by character and how many character display");
			System.out.println("Query       : Select Name from student where Name like 'A__' ");
			System.out.println();
			System.out.println("Description : That Query is Use to Display Student Name by Address");
			System.out.println("Query       : Select Name form student where Address in (' Adress(Ex. pune) ',' Adress(Ex. mumbai) ')");
			System.out.println();
			System.out.println("Description : That Query is Use to Display Student Name by marks range");
			System.out.println("Query       : Select Name from student where Marks Between Marks(EX. 85) and Marks(EX. 95) ");
			System.out.println();
			System.out.println("Description : That Query is Use to Display count of rollno by address");
			System.out.println("Query       : Select count(RollNo) , Address from Student Group by Address ");
			System.out.println();
			System.out.println("Description : That Query is Use to Display order by name");
			System.out.println("Query       : Select * from student Order by Name ");
			System.out.println();
		/*	System.out.println("Description : That Query is Use to Display contents of Student table in Descending order by there Marks");
			System.out.println("Query       : Select * from student where address = Address(Ex. Pune) Order by Marks DESC ");
			System.out.println();
			*/			
			
		}
		else if("delete".equals(name))
		{	
			System.out.println("Description : Use to delete all ");
			System.out.println("Query       : delete * from student ");
			System.out.println();
			System.out.println("Description : Use to delete by rollno");
			System.out.println("Query       : delete from student where rollno = RollNo(Ex. 11)");
			System.out.println();
			System.out.println("Description : Use to delete by mark");
			System.out.println("Query       : delete from student where marks = Marks(Ex. 90)");
			System.out.println();
		
			
		}
		else if("Insert".equals(name))
		{
			System.out.println("Description : Use to Insert data");
			System.out.println("Query       : Insert into student Name(Ex. Geetesh) Address(Ex. Mumbai) Marks(Ex. 90)");
			System.out.println();
		}
		else if("Man".equals(name))
		{
			System.out.println("Description : Use to show the Description and how to use query");
			System.out.println("Query       : Man any(Select,Insert,delete)");
			System.out.println();
		}
		else 
		{
			System.out.println("Query not found ....!!!");
		}
	 }
	
	/////////////////////////////////////////////////////////////////////
	//
	//  Function Name :  InsertData	
	//  Description   :  Used to Insert data by Name Address and Marks
	//  Input         :  String,String, Integer
	//  Output        :  void
	//  Date 		  :  28/07/2022
	//  Author 		  :  Geetesh Gajanan Kumbalkar
	//
	/////////////////////////////////////////////////////////////////////

	 public void InsertData(String str,String str1,int value)
	 {
		 Student sobj=new Student(str,str1,value);
		 lobj.add(sobj);
		
	 }
    /////////////////////////////////////////////////////////////////////
    //
    //  Function Name :  DisplayAll	
	//  Description   :  Used to Display all Data
	//  Input         :  NONE
	//  Output        :  void
	//  Date 		  :  28/07/2022
	//  Author 		  :  Geetesh Gajanan Kumbalkar
	//
	/////////////////////////////////////////////////////////////////////

	 public void DisplayAll()
	 {
		 System.out.println("---------------------------------------------------------------------------------");
	 
		 System.out.println("|\t RollNo \t|\t Name \t|\t Address \t|\t Marks \t|");
		 System.out.println("---------------------------------------------------------------------------------");

	 
		 for(Student sref : lobj)
		 {
			 sref.DisplayData();
		 }
		 System.out.println();
	 }
    /////////////////////////////////////////////////////////////////////
    //
    //  Function Name :  DisplaySpecifiC	
	//  Description   :  Used to Display by RollNo or Marks
	//  Input         :  integer
	//  Output        :  void
	//  Date 		  :  28/07/2022
	//  Author 		  :  Geetesh Gajanan Kumbalkar
	//
	/////////////////////////////////////////////////////////////////////
 
	 public void DisplaySpecific(int no)
	 { 
		System.out.println("---------------------------------------------------------------------------------");
	 
		 System.out.println("|\t RollNo \t|\t Name \t|\t Address \t|\t Marks \t|");
		 System.out.println("---------------------------------------------------------------------------------");

		 
		 for(Student sref : lobj)
		 {
			 if((sref.RollNo == no)||(sref.Marks == no))
			 {
				sref.DisplayData();
				break;
			 }
		 }
	 }
   
    /////////////////////////////////////////////////////////////////////
    //
    //  Function Name :  DisplaySpecifiC	
	//  Description   :  Used to Display by Name or Address
	//  Input         :  String
	//  Output        :  void
	//  Date 		  :  28/07/2022
	//  Author 		  :  Geetesh Gajanan Kumbalkar
	//
	/////////////////////////////////////////////////////////////////////
 
	 public void DisplaySpecific(String str)
	 { 
		System.out.println("---------------------------------------------------------------------------------");
	 
		 System.out.println("|\t RollNo \t|\t Name \t|\t Address \t|\t Marks \t|");
		 System.out.println("---------------------------------------------------------------------------------");

		 for(Student sref : lobj)
		 {
			 if(str.equals(sref.Name)||(str.equals(sref.Address)))
			 {
				sref.DisplayData();
				
			 }
		 }
	 }
   
    /////////////////////////////////////////////////////////////////////
    //
    //  Function Name :  DisplaySpecifiC	
	//  Description   :  Used to Display by Name or Address
	//  Input         :  String
	//  Output        :  void
	//  Date 		  :  28/07/2022
	//  Author 		  :  Geetesh Gajanan Kumbalkar
	//
	/////////////////////////////////////////////////////////////////////
 
	
	 public void DisplaySpecifiC(String str)
	 { 
		 for(Student sref : lobj)
		 {
			 if(str.equals(sref.Name)||(str.equals(sref.Address)))
			 {
				sref.DisplayData();
				
			 }
		 }
	 }
	
	/////////////////////////////////////////////////////////////////////
    //
    //  Function Name :  DisplaySpecifiC	
	//  Description   :  Used to Display by marks and Address
	//  Input         :  String
	//  Output        :  void
	//  Date 		  :  28/07/2022
	//  Author 		  :  Geetesh Gajanan Kumbalkar
	//
	/////////////////////////////////////////////////////////////////////
	
	public void DisplaySpecific(int mark,String address)
	{ 
		System.out.println("---------------------------------------------------------------------------------");
	 
		System.out.println("|\t RollNo \t|\t Name \t|\t Address \t|\t Marks \t|");
		System.out.println("---------------------------------------------------------------------------------");

			
		 for(Student sref : lobj)
		 {
			 if((address.equals(sref.Address))&&(mark<(sref.Marks)))
			 {
				sref.DisplayData();
			
			 }
		 }
	 }
	/////////////////////////////////////////////////////////////////////
    //
    //  Function Name :  AggregateMinMarks	
	//  Description   :  Used to Display by Minimum Aggregate
	//  Input         :  NONE
	//  Output        :  void
	//  Date 		  :  29/07/2022
	//  Author 		  :  Geetesh Gajanan Kumbalkar
	//
	/////////////////////////////////////////////////////////////////////
	public void AggregateMinMarks()
	 {
	 	System.out.println("---------------------------------------------------------------------------------");
		System.out.println("|\t RollNo \t|\t Name \t|\t Address \t|\t Marks \t|");
		System.out.println("---------------------------------------------------------------------------------");

		 int iMin=(lobj.getFirst()).Marks;
		 Student temp = lobj.getFirst();
		 
		 for(Student sref : lobj)
		 {
			 if(sref.Marks<iMin)
			 {
				 iMin=sref.Marks;
				 temp=sref;
			 }
		 }
		 
			temp.DisplayData();
	 }
 	/////////////////////////////////////////////////////////////////////
    //
    //  Function Name :  AggregateMaxMarks	
	//  Description   :  Used to Display by Maximum Aggregate
	//  Input         :  NONE
	//  Output        :  void
	//  Date 		  :  29/07/2022
	//  Author 		  :  Geetesh Gajanan Kumbalkar
	//
	/////////////////////////////////////////////////////////////////////
	
	 public void AggregateMaxMarks()
	 {
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("|\t RollNo \t|\t Name \t|\t Address \t|\t Marks \t|");
		System.out.println("---------------------------------------------------------------------------------");

		 int iMax=(lobj.getFirst()).Marks;
		 Student temp = lobj.getFirst();
		 
		 for(Student sref : lobj)
		 {
			 if(sref.Marks>iMax)
			 {
				 iMax=sref.Marks;
				 temp=sref;
			 }
		 }
		 
			temp.DisplayData();
	 }
	/////////////////////////////////////////////////////////////////////
    //
    //  Function Name :  CountByMark	
	//  Description   :  Used to Display Count by student marks
	//  Input         :  integer
	//  Output        :  void
	//  Date 		  :  30/07/2022
	//  Author 		  :  Geetesh Gajanan Kumbalkar
	//
	/////////////////////////////////////////////////////////////////////
	
	 public void CountByMark(int marks)
	 {
		 System.out.println("-----------------");
		 System.out.println("| COUNT(Marks)  |");
		 System.out.println("-----------------");
		 
		 int iCnt=0;
		 for(Student sref : lobj)
		 {
			 if(sref.Marks > marks)
			 {
				 iCnt++;
			 }
		 }
		 System.out.println("|\t"+iCnt+"\t|");
		 System.out.println("-----------------");
		 
	 }
	/////////////////////////////////////////////////////////////////////
    //
    //  Function Name :  AggregateAvg	
	//  Description   :  Used to Display average of all marks
	//  Input         :  NONE
	//  Output        :  void
	//  Date 		  :  30/07/2022
	//  Author 		  :  Geetesh Gajanan Kumbalkar
	//
	/////////////////////////////////////////////////////////////////////
	 public void AggregateAvg()
	 {
		 System.out.println("-----------------");
		 System.out.println("|  AVG(Marks)   |");
		 System.out.println("-----------------");
		 
		 float iAvg=0.00f;
		 
		 for(Student sref : lobj)
		 {
			 iAvg=sref.Marks+iAvg;
		 }
		 System.out.println("|\t"+iAvg/(lobj.size())+"\t|");
		 System.out.println("-----------------");
		 
	 }
	/////////////////////////////////////////////////////////////////////
    //
    //  Function Name :  SumOfMark	
	//  Description   :  Used to Display Sum of all student marks
	//  Input         :  NONE
	//  Output        :  void
	//  Date 		  :  30/07/2022
	//  Author 		  :  Geetesh Gajanan Kumbalkar
	//
	/////////////////////////////////////////////////////////////////////
	 public void SumOfMark()
	 {
		 System.out.println("-----------------");
		 System.out.println("|   SUM(Marks)  |");
		 System.out.println("-----------------");
		 
		 int iSum=0;
		 for(Student sref : lobj)
		 {
			 iSum=iSum+(sref.Marks);
		 }
		 System.out.println("|\t"+iSum+"\t|");
		 System.out.println("-----------------");
		 
	 }
	/////////////////////////////////////////////////////////////////////
    //
    //  Function Name :  Matching	
	//  Description   :  Used to Display Matching 
	//  Input         :  byte
	//  Output        :  void
	//  Date 		  :  30/07/2022
	//  Author 		  :  Geetesh Gajanan Kumbalkar
	//
	/////////////////////////////////////////////////////////////////////
	 public void Matching(byte btr)
	 {
		 char str=(char)btr;
		
		 System.out.println("----------------------");
		 System.out.println("|        Name        |");
		 System.out.println("----------------------");
		 
		
		 for(Student sref : lobj)
		 {
			 byte brr[]=(sref.Name).getBytes();
			 if((str == (char)brr[0])||((str+32) == (char)brr[0]))
			 {
				
				System.out.println("|\t"+sref.Name+"\t\t|");
				System.out.println("----------------------");
		  
			 }
		 }
	 }
	/////////////////////////////////////////////////////////////////////
    //
    //  Function Name :  Matching	
	//  Description   :  Used to Display Matching 
	//  Input         :  byte,integer
	//  Output        :  void
	//  Date 		  :  30/07/2022
	//  Author 		  :  Geetesh Gajanan Kumbalkar
	//
	/////////////////////////////////////////////////////////////////////
	 public void Matching(byte btr,int iCount)
	 {
		 System.out.println("----------------------");
		 System.out.println("|        Name        |");
		 System.out.println("----------------------");
		 
	
		 for(Student sref : lobj)
		 {
			 char Crr[]=(sref.Name).toCharArray();
			 if(iCount > Crr.length)
			 {
					System.out.println("your space is greater than name");
					break;
			 }
			 else if((char)btr == Crr[0])
			 {
					
			
					
					System.out.print("|\t");
					
					for(int iCnt=0;iCnt<iCount;iCnt++)
					{
						
				
						System.out.print(Crr[iCnt]);
					
					}
				
					System.out.println(" \t|");
					System.out.println("----------------------");
		  
			}
			
		 }
		 
	 }
	/////////////////////////////////////////////////////////////////////
    //
    //  Function Name :  DisplayNameByAddrres
	//  Description   :  Used to Display name by address 
	//  Input         :  String ,String  
	//  Output        :  void
	//  Date 		  :  30/07/2022
	//  Author 		  :  Geetesh Gajanan Kumbalkar
	//
	/////////////////////////////////////////////////////////////////////
	 public void DisplayNameByAddrres(String str1,String str2)
	 {
		 System.out.println("----------------------");
		 System.out.println("|        Name        |");
		 System.out.println("----------------------");
		 
		 for(Student sref : lobj)
		 {
			
			if((str1.equals(sref.Address))||((sref.Address).equals(str2)))
			 {
				 System.out.println("|\t"+sref.Name+"\t\t|");
				System.out.println("----------------------");
		  
			 }
		 }
	 }
	/////////////////////////////////////////////////////////////////////
    //
    //  Function Name :  DisplayRange
	//  Description   :  Used to Display by range 
	//  Input         :  integer ,integer  
	//  Output        :  void
	//  Date 		  :  01/08/2022
	//  Author 		  :  Geetesh Gajanan Kumbalkar
	//
	/////////////////////////////////////////////////////////////////////
	 public void DisplayRange(int no1, int no2)
	 {
		 System.out.println("----------------------");
		 System.out.println("|        Name        |");
		 System.out.println("----------------------");
		 
		 for(Student sref : lobj)
		 {
			
			if(((no1<= (sref.Marks))&&((sref.Marks)<=no2))||((no1>= (sref.Marks))&&((sref.Marks)>=no2)))
			 {
				 System.out.println("|\t"+sref.Name+"\t\t|");
				System.out.println("----------------------");
		  
			 }
		 }
	 }
	/////////////////////////////////////////////////////////////////////
    //
    //  Function Name :  CountRoll
	//  Description   :  Used to Count Roll No 
	//  Input         :  String
	//  Output        :  integer
	//  Date 		  :  01/08/2022
	//  Author 		  :  Geetesh Gajanan Kumbalkar
	//
	/////////////////////////////////////////////////////////////////////
	 public int CountRoll(String address)
	 { 
		int iCnt=0;
		 for(Student sref : lobj)
		 {
			
			 if((sref.Address).equals(address))
			 {
				 iCnt++;
			 }
			 
			
		 }
		 return iCnt; 
	 }
	/////////////////////////////////////////////////////////////////////
    //
    //  Function Name :  CountAll
	//  Description   :  Used to Count All Element in DBMS
	//  Input         :  NONE
	//  Output        :  integer
	//  Date 		  :  02/08/2022
	//  Author 		  :  Geetesh Gajanan Kumbalkar
	//
	/////////////////////////////////////////////////////////////////////
	 public int CountAll()
	 {
		 int iCnt = 0;
		 for(Student sref : lobj)
		 {
			 iCnt++;
		 }
		 return iCnt;
	 }
	/////////////////////////////////////////////////////////////////////
    //
    //  Function Name :  DisplayGrpByAddress
	//  Description   :  Used to Display Count of address from student group by address
	//  Input         :  NONE
	//  Output        :  void
	//  Date 		  :  02/08/2022
	//  Author 		  :  Geetesh Gajanan Kumbalkar
	//
	/////////////////////////////////////////////////////////////////////
	public void DisplayGrpByAddress()
	 {
		 System.out.println("--------------------------------------------------");
		 System.out.println("|   count(RollNo) \t|\t Address \t|");
		 System.out.println("--------------------------------------------------");
		int iRet=0;
		for(Student sref : lobj)
		{
			iRet=CountRoll(sref.Address);
			System.out.println("|\t"+iRet+"\t|\t"+sref.Address+"\t");
			System.out.println("--------------------------------------------------");
		  			
		}			
	 }
	/////////////////////////////////////////////////////////////////////
    //
    //  Function Name :	 DisplayOrderByName
	//  Description   :  Used to Display Order by name
	//  Input         :  NONE
	//  Output        :  void
	//  Date 		  :  02/08/2022
	//  Author 		  :  Geetesh Gajanan Kumbalkar
	//
	/////////////////////////////////////////////////////////////////////
	 public void DisplayOrderByName()
	 {
		 System.out.println("---------------------------------------------------------------------------------");
	 
		 System.out.println("|\t RollNo \t|\t Name \t|\t Address \t|\t Marks \t|");
		 System.out.println("---------------------------------------------------------------------------------");
		
		 for(int iCnt='A';iCnt<='Z';iCnt++)
		 {
			 for(Student sref : lobj)
			 {
				 byte byteArray[]=(sref.Name).getBytes();
				 if(((char)iCnt == ((char)byteArray[0]))||((char)(iCnt+32) == ((char)byteArray[0])))
				 {
					 DisplaySpecifiC(sref.Name);
				 }
			 }
		 }
	 }
	/////////////////////////////////////////////////////////////////////
    //
    //  Function Name :	 DeleteSpecific
	//  Description   :  Used to Delete by RollNo
	//  Input         :  integer
	//  Output        :  void
	//  Date 		  :  03/08/2022
	//  Author 		  :  Geetesh Gajanan Kumbalkar
	//
	/////////////////////////////////////////////////////////////////////
	public void DeleteSpecific(int rollno)
	 {
	
		 int index=0;
		  for(Student sref : lobj)
		  {
			if(sref.RollNo == rollno)
			 {	  
				lobj.remove(index);
				break;
			 }
			 
		  index++;
		  }
	 
	 }
	/////////////////////////////////////////////////////////////////////
    //
    //  Function Name :	 DeleteSpecific
	//  Description   :  Used to Delete by marks
	//  Input         :  integer
	//  Output        :  void
	//  Date 		  :  03/08/2022
	//  Author 		  :  Geetesh Gajanan Kumbalkar
	//
	/////////////////////////////////////////////////////////////////////
	public void Deletespecific(int marks)
	 {
		 int index=0;
		  for(Student sref : lobj)
		  {
			if(sref.Marks == marks)
			 {
				lobj.remove(index);
				break;
			 }
			 
		  index++;
		  }
	 
	 }
	/////////////////////////////////////////////////////////////////////
    //
    //  Function Name :	 DeleteSpecific
	//  Description   :  Used to Delete All 
	//  Input         :  NONE
	//  Output        :  void
	//  Date 		  :  03/08/2022
	//  Author 		  :  Geetesh Gajanan Kumbalkar
	//
	/////////////////////////////////////////////////////////////////////
	 public void DeleteAll()
	 {
		 int Size=CountAll();
		 
		 for(int i=1;i<=Size;i++)
		 {
			 DeleteSpecific(i);  
			 
		 }
	 }
		
 }
 class DBMS1
 {
	 public static void main(String arg[])
	 {
			
		DBMS dobj=new DBMS();
		dobj.StartDBMS();
	}
 }
 
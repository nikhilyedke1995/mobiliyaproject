# mobiliyaproject
Client Registration Application

# Steps to Setup

# 1. Clone the repository

    	git clone https://github.com/nikhilyedke1995/mobiliyaproject.git
  
# 2. Create a database in MySQL using below details.
  	DB name : test
  	Username : root
  	password : 
  
# 3. Run the app using maven 

  	cd mobiliyaproject
 	 mvn spring-boot:run

# 4. Use below endpoint to check the application using POSTMAN.

  	1) register a candidate 
  	POST : http://localhost:8080/candidate
  	Body : 
  	{
	"name":"Nikhil Yedke",
	"qualification":"BE",
	"experience":2,
	"createdOn":"2019-11-28",
	"skills":"Java",
	"exams" : [
		{
			"position":"Software Engineer",
			"examDate":"2019-11-12"
		},
		{
			"position":"Software Engineer - 2",
			"examDate":"2019-11-12"
		}
		]
	
	}
	
	![alt text](/images/candidatesave.PNG)

	2) TO get candidate information
	GET : http://localhost:8080/candidate/{id}
	![alt text](/images/fetchcandidate.PNG)
	


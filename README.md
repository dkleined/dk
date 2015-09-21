# dk
DK Image


The idea behind my test app is a crowd sourced stock photo library. Basically, users can create an account, upload photos, and sell those photos to other users. This opens up the opportunity to use the Payfirma API in two ways:
1) As a transaction manager
2) As a user manager

I used the following technology stack to create a two-tier web project:
-Java Server Pages
-Spring MVC
-Hibernate
-MySql

I didn't have time to produce a production quality project, so what I am presenting is a proof of concept. As a proof of concept there is a number of things I would improve on if given more time. These things include but are not limited to:
-Security; right now I am storing most sensitive data in plain text and via unsecured http calls. 
-Architectural model; I chose the 2 tier approach mainly because it is an easier architecture to pull off in a few days, and the job I am applying for is a full stack Java position. Given more time I would move to a 3-tier client/server model. I would expose the CRUD functionality via a RESTful API and enforce an OAuth flow. This gives the advantage of having the service be agnostic to the type of client as well as providing heightened security for the user and their sensitive data.
-Integration with Payfirma API; I left the integration with the API until the end because I was confident in my ability to work around your API's after reading the documentation and having experience in API management through CA Technologies. In hindsight this was a short sighted decision. 

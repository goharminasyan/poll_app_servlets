# poll_web_app
Implemented for the polling system:

The poll includes several questions. Each question can have multiple answers.
Each answer option has a weight.
There can be several results for each poll, depending on the number of points scored by the user during the survey.
The result of the poll includes the corresponding range of scores and decoding. To determine the result, the system must sum the weights for each user response.
![image](https://user-images.githubusercontent.com/93138699/162828157-5bdd634d-ee8d-4515-a1a3-45a4632bbf13.png)

Created JDBC connection.

Developed web layer.

The application runs on Servlet / JSP technologies, runs in the tomcat servlet container.

The application has 6 pages:
1. Login page if user registered and
2. Registration page if not
3. Home page where information about user and poll button
4. List of poll (tests)
5. Page taking a poll
6. Results

Implemented functionality allowing the user to take one survey no more than once a week. If less than a week has passed since the last pass, the result of the last pass is shown to the user.

There are pages design with css.

DB schema

![image](https://user-images.githubusercontent.com/93138699/159952566-5d2575f9-bef3-40f7-8aa0-42e7da882655.png)

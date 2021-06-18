# Smart-Recycle

## Contetns
- [Description](#description)

- [Roadmap](#roadmap)

- [Live Demo](#live-demo)

- [Built With](#built-with)

- [Contributors](#contributors)

## Description

The features of this app are :

- **Splash Screen** : As soon as user opens the app, the welcoming screen that is splash screen appears and remains on the mobile screen for 5 seconds. Animations are also added.

![image](https://github.com/Vriddhigupta/Smart-Recycle/blob/main/Screenshots/splash_screen.jpeg)

- **Login** : Login feature is implemented for personal use experience. The feature is implemented using SQLite3 database which consists for two table: one for company and other for consumers. When the user enters the creentials that is email and password, the app checks both the database tables to find a match. If match is found then the user is logged in or else incorrect credentials message is shown.

![image](https://github.com/Vriddhigupta/Smart-Recycle/blob/main/Screenshots/login%20page.jpeg)

- **Company registration** : Recycling Companies can register here so that the consumers can book the company and the company can send a person to take plastic and paper. This is implemented using SQLite3 database in which company table is created which holds data like company name, email, password, state, city and contact number. This data is inserted into the table when user clicks on register button and all the fields are completely filled. If there is an existing company name or email in the table then the company data is not inserted instead user is asked to change the input data.

![image](https://github.com/Vriddhigupta/Smart-Recycle/blob/main/Screenshots/register%20company.jpeg)

- **Consumer signup** : Consumers that is customers can create their own user account and book companies to take out their waste plastic and paper for recycling. This is implemented using SQLite3 database in which users table is created which holds data like username, email and password. This data is inserted into the table when user clicks on sign up button and all the fields are completely filled. If there is an existing username or email in the table then the user data is not inserted instead user is asked to change the input data.\

![image](https://github.com/Vriddhigupta/Smart-Recycle/blob/main/Screenshots/consumer_signup.jpeg)

- **Dashboard** : It is a page where there are buttons to search for companies, to go to blog page and to logout of the account.

![image](https://github.com/Vriddhigupta/Smart-Recycle/blob/main/Screenshots/dashboard.jpeg)

- **List of companies** : Here the user can see the list of all registered recycling companies and select anyone out of them. This feature is implemented using SQLite3 database. When a company registers, the company name, state, city and contact number are also stored in the database table. So we have used a recycler view, retrieved this data from the table and displayed it in the form of list. 

![image](https://github.com/Vriddhigupta/Smart-Recycle/blob/main/Screenshots/company_list.jpeg)

- **Company description and book your slot button** : After clicking on a company from the list of companies, the description page opens which consists of company name, State,City and contact number. It also consists a Button which directs the user to the booking page of that company.

![image](https://github.com/Vriddhigupta/Smart-Recycle/blob/main/Screenshots/company_desc.jpeg)

- **Booking Page** : It consists of a spinner which has different time slots from which user can select a time slot which is feasible to them. The company person will arrive between the selected time slot to collect paper and plastic. It also consists of Address box in which the user needs to provide a proper address so that the company person can reach the correct location.

![image](https://github.com/Vriddhigupta/Smart-Recycle/blob/main/Screenshots/book%20your%20slot.jpeg)

- **Blog Page** : Here the user can select either to view all the blogs posted by different users or to create a blog post. This blogs are related to environment and the main purpose of having this blog feature is to create awareness about different environmental conditions like global warming, climatic changes,extinction,etc and to give solutions to environmental issues.

![image](https://github.com/Vriddhigupta/Smart-Recycle/blob/main/Screenshots/Blog%20page.jpeg)

- **Create Blog** : In order to create and display the blog we have used database table "blogs" which holds two attributes that is post title and post description(blog content). So when the user fills the title and content, it is inserted into the database table "blogs". If the user leaves any field empty then the data is no inserted.

![image](https://github.com/Vriddhigupta/Smart-Recycle/blob/main/Screenshots/create_blog.jpeg)

- **Blog List** : Here the user can find all the current blogs posted by other users. Blog list consists of cards which is arranged in the form of list. This cards consists of blog titles and upon clicking on this cards, the user is directed to the blog content page where they can read the blogs. These titles are retrieved fromthe database table.It is a page where user can read the entire blog. This page is assisted with a scrollview so that there is no restriction on the number of blogs.

![image](https://github.com/Vriddhigupta/Smart-Recycle/blob/main/Screenshots/blog%20list.jpeg)

- **Blog Content** : It is a page where user can read the entire blog. This page is assisted with a scrollview so that there is no restriction on the length of content.

![image](https://github.com/Vriddhigupta/Smart-Recycle/blob/main/Screenshots/blog%20content.jpeg)

- **ChatBot** : We have implemented a chatbot which will give information about environmental issues, trees,importance of recycling,etc. The main purpose is to let people know why recycling is important and why trees are important. The chatbot is implemenetd using three services of IBM Cloud namely Text to Speech, Speech to Text and Watson Assistant. The chatbot speaks while answering your question and you can also use your phone mic to type questions.

![image](https://github.com/Vriddhigupta/Smart-Recycle/blob/main/Screenshots/chatbot.jpeg)


## Roadmap

The project offers
- Login and Sign Up feature along with Forgot Passsword feature.
- A list of Companies registered in the app. 
- Booking Slots feature 
- A Blogs Section which contains blogs and articles , made with the intention to increase awareness about important environemntal topics.

In the future, we plan to include a Company Oriented Version of the app , which would enable them to see ,accept or reject the slots booked by the Customers.

![Untitled (4)](https://user-images.githubusercontent.com/54906653/122470791-19f25a00-cfdc-11eb-838e-036989bc01e4.jpg)

## Live demo

You can find a Video Demonstration of Our App at - 
[Please Click here to go to the demo on YouTube](https://www.youtube.com/watch?v=6fnXCcBUGYY)


## Built with
- Android Studio : For the development of the App
- SqLite3 : Fot the backend support of the App.
- IBM Cloud Services - Speech to Text, Text to Speech, IBM Watson Assistant

## Contributors 
1. Vriddhi Gupta 
2. Krishna Rajendra Asher

# Fuel-Station-Project
This project is a Fuel Station Management System. In this context, you are a large corporate fuel company that wants to facilitate management at gas stations.

When the user selects the 1st option, 
The program should create a new
Station object and add it to the stationArray. So firstly, the program
should ask the station name and station ID and by using this information, it
should create the Station object.

When the user selects the 2nd option, 
The program should ask for a station ID
to search the stationArray and find the Station object that has the given
ID. When the object is found, then the program should create a Gasoline
object by requesting the information from the user. This Gasoline object
then should be added to the gasolineArray of the corresponding Station
object. If there are no Stations in the stationArray with the given ID,
then the program should print “No station found with the given ID!”.

When the user selects the 3rd option, 
The program should ask for a station ID
to search the stationArray and find the Station object that has the given
ID. When the object is found, then the program should create a Diesel object
by requesting the information from the user. This Diesel object then should
be added to the dieselArray of the corresponding Station object. If there
are no Stations in the stationArray with the given ID, then the program
should print “No station found with the given ID!”.

When the user selects the 4th option, 
The program should ask for a station ID
to search the stationArray and find the Station object that has the given
ID. When the object is found, then the program should print all of the
Gasoline and Diesel inventory by iterating over the gasolineArray and
dieselArray of the corresponding Station object. If there are no
Stations in the stationArray with the given ID, then the program should
print “No station found with the given ID!”.

When the user selects the 5th option, 
The program should ask for a station ID
to search the stationArray and find the Station object that has the given
ID. When the object is found, then the program should create a
GasolineService object by requesting the information (car plate, liters,
and coupon) from the user. The program should check if there is enough
gasoline in the station before initiating the transaction. If there is not enough
gasoline, then it should print “Not enough gasoline in the station!”. If
everything is ok, the program should initiate the transaction by calling the
makeTransaction() method by passing the average gasoline price in this
particular station. The liter of gasoline that the customer bought should be
deducted from the total gasoline liter count of the station. Then, this
GasolineService object should be added to the serviceArray of the
corresponding Station object. If there are no Stations in the
stationArray with the given ID, then the program should print “No station
found with the given ID!”.

When the user selects the 6th option, 
The program should ask for a station ID
to search the stationArray and find the Station object that has the given
ID. When the object is found, then the program should create a
DieselService object by requesting the information (car plate, liters, and
anti-freeze) from the user. The program should check if there is enough diesel
in the station before initiating the transaction. If there is not enough diesel,
then it should print “Not enough diesel in the station!”. If everything is ok, the
program should initiate the transaction by calling the makeTransaction()
method by passing the average diesel price in this particular station. The liter
of diesel that the customer bought should be deducted from the total diesel
liter count of the station. Then, this DieselService object should be added
to the serviceArray of the corresponding Station object. If there are no
Stations in the stationArray with the given ID, then the program should
print “No station found with the given ID!”.

When the user selects the 7th option, 
The program should ask for a station ID
to search the stationArray and find the Station object that has the given
ID. When the object is found, then the program should create a CarWash
object by requesting the information (car plate) from the user. Then, this
CarWash object should be added to the serviceArray of the corresponding
Station object. If there are no Stations in the stationArray with the
given ID, then the program should print “No station found with the given
ID!”.

When the user selects the 8th option, 
The program should ask for a station ID
to search the stationArray and find the Station object that has the given
ID. When the object is found, then the program should print all of the
GasolineService and DieselService records by iterating over the
serviceArray of the corresponding Station object. If there are no
Stations in the stationArray with the given ID, then the program should
print “No station found with the given ID!”. The services should be sorted in default
manner according to their prices.


When the user selects the 9th option, 
A sub-menu should appear to ask for
personnel or manager. Then, the program should ask for a station ID to search
the stationArray and find the Station object that has the given ID. When
the object is found, then the program should create a Personnel/Manager
object by requesting the information from the user. Then, this
Personnel/Manager object should be added to the personList of the
corresponding Station object. If there are no Stations in the
stationArray with the given ID, then the program should print “No station
found with the given ID!”.

When the user selects the 10th option, 
The program should ask for a station ID
to search the stationArray and find the Station object that has the given
ID. The program should call the calculate() method of each object and
calculate the overall profit (weather - or +) of the station. Note that you can
use an ArrayList<Profitable> to add all the applicable objects when adding
them to their respective arrays.

When the user selects the 11th option, 
The services should be sorted according
to their car plates by the help of a Comparator.

When a user selects the 0th option, 
Your application should terminate.

![1](https://user-images.githubusercontent.com/79373487/174450386-4ee9a042-ecc1-4241-b900-951a386e05a5.png)
![2](https://user-images.githubusercontent.com/79373487/174450389-f0f52932-42dd-437f-a9d1-a7f4a048d4f1.png)
![3](https://user-images.githubusercontent.com/79373487/174450391-cd880bb0-60e1-4458-900a-c278e7e8000c.png)
![4](https://user-images.githubusercontent.com/79373487/174450394-25b26552-a144-496f-ac79-47887beefe50.png)
![5](https://user-images.githubusercontent.com/79373487/174450398-1abc67fb-b3f4-4d28-973b-d994ffb24602.png)
![6](https://user-images.githubusercontent.com/79373487/174450400-eb13c5c4-1183-4599-9b60-061d33406b16.png)
![7](https://user-images.githubusercontent.com/79373487/174450405-bb18eb27-5148-40b5-8b12-c0521b0fe334.png)
![8](https://user-images.githubusercontent.com/79373487/174450407-6dad4f6b-4c45-4078-ba6a-e4f38d7a8047.png)

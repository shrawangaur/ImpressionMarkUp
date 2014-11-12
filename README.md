ImpressionMarkUp
================

A global publishing company that publishes books and journals wants to develop a service to add Springer Impression to their documents. Book publications include topics in business, science and media. Journals don’t include any specific topics. A document (books, journals) has a title, author and an impression-mark property. An empty impression-mark property indicates that the document has not been impression-marked yet.
 
The impression marking service has to be asynchronous. For a given content document the service should return a ticket, which can be used to poll the status of processing. If the impression marking is finished, then the document can be retrieved with the ticket. The impression-mark of a book or a journal is identified by setting the impression-mark property of the object. For a book the impression-mark includes the properties content, title, author and topic. The journal impression-mark includes the content, title and author.
 
Examples for impression-marks:
{content:”book”, title:”The Dark Code”, author:”Bruce Wayne”, topic:”Science”}
{content:”book”, title:”How to make money”, author:”Dr. Evil”, topic:”Business”}
{content:”journal”, title:”Journal of human flight routes”, author:”Clark Kent”}
 
 
a)      Create an appropriate object-oriented model for the problem.
b)      Implement the Impression-mark Service, meeting the above conditions.
c)       Provide Unit-Tests to ensure the functionality of the service.




--------------------------

Assumptions/Solution -
------------------------

I have created some models.

Document which is a abstract class has one abstract method (markImpression) and has common parameters from its sub classes ,i.e Book and Journal.
Book additionally has topic and I have used TopicType enum for that purpose.

Used constructer based injection for creating objects of Book and Journal class. Also, used Constructor chaining for making call to Document class.

My take on the problem is that when document is provided as input to service factory, it will accept that and will return ticket which for now contains
only Ticket number which is randomly generated.

It will also create a map where Ticket will be key and submitted document will be value. (This submitted document will be added into another list of pending Impression)
Now, I have created a thread which will be invoked and will fetch records from this pending list and mark impression.

So, if before invocation of thread, a query is made for status, it will return false as it has not yet been marked with impression.
However, if after invocation of thread, a query is made for status, it will return true and with help of ticket , we can obtain document with impression.

I have managed time by managing sleep time in Thread.sleep(long millis) method.

I have also added a main method just to see this behavior.

Since, it is a thread, it will be asynchronous in nature.

I have also added test to cover business requirements in this case.

Feel free to get in touch with me if you have any query.

Happy Coding!!
Shrawan
9970166053







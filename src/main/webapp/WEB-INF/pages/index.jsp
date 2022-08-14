<%@ page import="com.example.simpletest.dao.UserDao" %>
<%@ page import="com.example.simpletest.dao.impl.UserDaoImpl" %>
<%@ page import="com.example.simpletest.model.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Search </title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script><%@include file="../../user.js"%></script>
    <script type="text/javascript" src="../../user.js"></script>
    <!--Bootstrap import -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</head>
<body>
<%
//    HttpSession session1 = request.getSession(false);
//    User u  = (User)session1.getAttribute("user");
//    if(u==null)
//        response.sendRedirect(request.getContextPath() + "/auth?action=login");

    List<User> list=(List<User>) request.getAttribute("list");
    System.out.println(list);
%>
<div>
    <div class="container">
        <div style="display: flex">
            <div >
                <form action="user" method="POST">
                    <div class="form-group m-3">
                        <label>Username:</label>
                        <input placeholder="Enter username" class="form-search" type="text" name="username" value=""/>
                        <button type="submit" class="btn btn-primary">Search</button>
                    </div>
                </form>
            </div>
            <form style="margin: 18px">
                <span class="form-group m-3" style="padding-left: 600px">
                <a name="logout" href="<%=request.getContextPath()%>/auth?action=logout" class="btn btn-secondary">Log out</a>
                </span>
            </form>
        </div>

        <div >
            <table class="table">
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Surname</th>
                    <th>Username</th>

                </tr>
                </thead>

                <tbody>
                <%for(User user : list){%>

                <tr>
                    <td><%=user.getFirstName()%></td>
                    <td><%=user.getLastName()%></td>
                    <td><%=user.getUsername()%></td>
                    <td style="width: 5px">

                        <input type="hidden" name="id" value="<%=user.getId()%>"/>
                        <input type="hidden" name="action" value="delete"/>
                        <button onclick="setDeleteId('<%=user.getId()%>')" class="btn btn-danger" type="submit" value="delete" data-toggle="modal" data-target="#exampleModal">
                            <i class="fas fa-trash-alt"></i>
                        </button>

                    </td>
                    <td style="width: 5px">

                            <input type="hidden" name="id" value="<%=user.getId()%>"/>
                            <input type="hidden" name="action" value="update"/>
                            <button onclick="setUpdateData('<%=user.getId()%>','<%=user.getFirstName()%>','<%=user.getLastName()%>','<%=user.getUsername()%>','<%=user.getPassword()%>')" class="btn btn-secondary" type="submit" value="update" data-toggle="modal" data-target="#exampleModalUpdate">
                                <i class="fas fa-pen-square"></i>
                            </button >

                    </td>
                </tr>
                <%}%>

                </tbody>
            </table>
        </div>
        </div>

    <!-- Modal for delete button -->
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Delete</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    Are you sure?
                </div>
                <div class="modal-footer">
                    <form action="userinfo" method="POST">
                        <input type="hidden" name="id" value="" id="idDelete"/>
                        <input type="hidden" name="action" value="delete"/>
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <input type="submit" class="btn btn-danger" value="Delete"/>
                    </form>
                </div>
            </div>
        </div>
</div>
    <!-- Modal for update button -->
    <div class="modal fade" id="exampleModalUpdate" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabelUpdate" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabelUpdate">Update</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form action="userinfo" method="POST">
                    <label for="upName">Name</label>
                    <input name="upName" type="text" value="" class="form-control" id="upName"placeholder="Enter name">
                    <br>
                    <label for="upSurname">Surname</label>
                    <input name="upSurname" type="text" value="" class="form-control" id="upSurname"placeholder="Enter surname">
                    <br>
                    <label for="upUsername">Username</label>
                    <input name="upUsername" type="text" value="" class="form-control" id="upUsername"placeholder="Enter username">
                    <br>
                    <label for="upPassword">Password</label>
                    <input name="upPassword" type="text" value="" class="form-control" id="upPassword"placeholder="Enter password">

                        <div class="modal-footer">

                                <input type="hidden" name="id" value="" id="idUpdate"/>
                                <input type="hidden" name="action" value="update"/>
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                <input  type="submit" class="btn btn-primary" value="Update"/>
                        </div>
                    </form>
            </div>

        </div>
        </div>
    </div>
</div>

</body>
</html>
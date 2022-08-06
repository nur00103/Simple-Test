function setDeleteId(id){
   var del=document.getElementById("idDelete")
   del.value=id;
}
function setUpdateData(id,name,surname,username,password){
   var upId=document.getElementById("idUpdate")
   var upName=document.getElementById("upName");
   var upSurname=document.getElementById("upSurname")
   var upUsername=document.getElementById("upUsername")
   var upPassword=document.getElementById("upPassword")
   upId.value=id;
   upName.value=name;
   upSurname.value=surname;
   upUsername.value=username;
   upPassword.value=password;

}
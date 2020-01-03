

1.

http://192.168.0.105:8080/api/auth/signup

{
   "name":"Abhishek Dutta",
   "username":"abhipicku12",
   "email":"abhishek12dutta@gmail.com",
   "password":"password",
   "personalDetails":{
      "addressline1":"Meena Wood, Flat 3B, Block-C",
      "addressline2":null,
      "country":"India",
      "pincode":723133,
      "phnextn":91,
      "phnno":9733892131
   }
}

2.

http://localhost:8080/api/auth/signin

{
   "usernameOrEmail":"abhipicku12",
   "password":"password"

}

3.




Authorization : Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxIiwiaWF0IjoxNTc2Mzc2OTEzLCJleHAiOjE1NzY5ODE3MTN9.5uJyVbLlMKVSuLIerVc26Eu73U8iIszFOaXFUGYy29aNMLmr0V82chkFL_TKb6ThRbSbQa3sTRsr3nijRD-zCQ

4. TODO:

 {
            id:1,
            title: "Todo Item 1, compled todo functionality",
			priority:"High",
            desc: "This is First ToDO item",
            completed: true,
            date: "22/11/2019",
			tags:["abc","def","fgh"]
        }

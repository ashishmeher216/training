
      document.querySelector('.submit-button').addEventListener('click',(e)=>{
          e.preventDefault();
          console.log("before calling")
          validateform();
          console.log("after calling")
        })
      function validateform(e) {
        // const fname = document.getElementById("fname").value;
        // const lname = document.getElementById("lname").value;
        // const email = document.getElementById("email").value;
        // const password = document.getElementById("password").value;
        
        const fname = document.myform.firstname.value;
        const lname = document.myform.lastname.value;
        const email = document.myform.email.value;
        const password = document.myform.pass.value;
        const address = document.myform.address.value;
        console.log(fname, lname, email, password, address);
        if (fname == null || fname == "") {
          alert("First name can't be blank");
          return false;
        }
        else if (lname == null || lname == "") {
          alert("Last name can't be blank");
          return false;
        }

        else if (password == null || password == "" || password.length < 6) {
          alert("Password must be at least 6 characters long.");
          return false;
        }
        else if (address == null || address == "") {
          alert("Please fill the address.");
          return false;
        }
        return true;
      }
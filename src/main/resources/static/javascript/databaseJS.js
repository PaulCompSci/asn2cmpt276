
console.log("javascript file connected")

function deleteStudent(uid) {
   
    $.ajax({
        url: "/students/" + uid,
        method: "DELETE",
        success: function () {
            
            location.reload();
        }
    });
}


function editStudent(uid) {
    
    window.location.href = "/students/" + uid + "/edit";
}
function deleteStudent(id) {
    if (confirm("Are you sure you want to delete this student?")) {
        window.location.href = "/student/delete/" + id;
    }
}

function editStudent(uid) {
    
    var editUrl = "/student/edit/" + uid;

    
    window.location.href = editUrl;
}

function visualize() {
    window.location.href = "/student/visualization";
  }

  function goToMenu() {
    window.location.href = "/Menu.html"; 
}
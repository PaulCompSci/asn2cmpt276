
console.log("javascript file connected")

function deleteStudent(uid) {
    // Make an AJAX request to delete the student
    $.ajax({
        url: "/students/" + uid,
        method: "DELETE",
        success: function () {
            // Refresh the page after successful deletion
            location.reload();
        }
    });
}

// Function to handle editing a student
function editStudent(uid) {
    // Redirect to the edit student page
    window.location.href = "/students/" + uid + "/edit";
}
function deleteStudent(id) {
    if (confirm("Are you sure you want to delete this student?")) {
        window.location.href = "/student/delete/" + id;
    }
}

function editStudent(uid) {
    // Construct the URL for the edit.html page with the UID parameter
    var editUrl = "/student/edit/" + uid;

    // Redirect to the editUrl within the same folder
    window.location.href = editUrl;
}

function visualize() {
    window.location.href = "/student/visualization";
  }

  function goToMenu() {
    window.location.href = "/menu.html"; // Replace "menu.html" with the filename of your menu page
}
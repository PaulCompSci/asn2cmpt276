
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
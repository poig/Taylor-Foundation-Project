function dates() {
    const d = new Date();
    let date = d.getDate();
    let month = d.getMonth() + 1;
    let year = d.getFullYear();
    
    document.getElementById("date_Borrowed").value = year + "-" + month + "-" + date;

    let newdate = d.getDate() + 14;
    let newmonth = d.getMonth() + 1;
    let newyear = d.getFullYear();

    document.getElementById("date_Returned").value = newyear + "-" + newmonth + "-" + newdate;
}

function GetDetails(str) {
    if (str.length== 0) {
        document.getElementById("bookname").value = "";
        document.getElementById("author").value = "";
        return;

    } else {
        let xmlhttp = new XMLHttpRequest();
        xmlhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                let myObj = JSON.parse(this.responseText);
                document.getElementById("bookname").value = myObj [0];
                document.getElementById("author").value = myObj [1];
            }
        };
        xmlhttp.open("GET", "search.php?ID=" + str, true);
        xmlhttp.send();
    }
}

function deleteConfirm(book_id) {
    const response = confirm(`Are you sure you wish to delete record #${book_id}?`)

    if (response) {
        document.location.href = `deleteRecords.php?book_id=${book_id}`;
    }
}


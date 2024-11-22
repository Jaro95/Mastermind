



document.addEventListener('DOMContentLoaded', () => {
    document.querySelectorAll('#confirm-delete-user').forEach(link => {
        link.addEventListener('click', event => {
            if (!confirm('Czy na pewno chcesz usunąć użytkownika?')) {
                event.preventDefault();
            }
        });
    });
});

$(document).ready(function () {
    var table = $('#adminTable').DataTable({
        "paging": true,
        "ordering": true,
        "info": true
    });

    $('#searchBox').on('keyup', function () {
        table.search(this.value).draw();
    });
});

$(document).ready(function () {
    var table = $('#activitiesTable').DataTable({
        "paging": true,
        "ordering": true,
        "info": true
    });

    $('#searchBox').on('keyup', function () {
        table.search(this.value).draw();
    });
});
$(document).ready(function () {
    var table = $('#assignTable').DataTable({
        "paging": false,
        "ordering": false,
        "info": false,
        "dom": 't'
    });

    $('#searchBox').on('keyup', function () {
        table.search(this.value).draw();
    });
});










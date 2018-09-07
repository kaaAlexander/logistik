var activeFieldMenu = document.getElementById('main-heading');
var sidebarMenu = document.getElementById('menu-navigation');

for (var i = 0; i < sidebarMenu.children.length; i++) {
    if (sidebarMenu.children[i].children[0].innerText === activeFieldMenu.innerText&&sidebarMenu.children[i].style.border === "") {
        console.dir(sidebarMenu.children[i].children[0]);
        sidebarMenu.children[i].children[0].style.border = "2px solid #a4acae";

    }
}

// Dynamic Web Project 1 - JavaScript

document.addEventListener('DOMContentLoaded', function() {
    console.log('Dynamic Web Project 1 loaded successfully!');
    
    // Add animation to the container
    const container = document.querySelector('.container');
    if (container) {
        container.style.opacity = '0';
        container.style.transform = 'translateY(20px)';
        
        setTimeout(() => {
            container.style.transition = 'opacity 0.5s, transform 0.5s';
            container.style.opacity = '1';
            container.style.transform = 'translateY(0)';
        }, 100);
    }
    
    // Form validation
    const form = document.querySelector('form');
    if (form) {
        form.addEventListener('submit', function(e) {
            const nameInput = document.getElementById('name');
            if (nameInput && nameInput.value.trim() === '') {
                e.preventDefault();
                alert('Please enter your name!');
                nameInput.focus();
            }
        });
    }
});

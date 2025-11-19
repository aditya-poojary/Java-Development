// JSP Web Project - JavaScript

document.addEventListener('DOMContentLoaded', function() {
    console.log('🚀 JSP Web Project loaded successfully!');
    
    // Add fade-in animation to container
    const container = document.querySelector('.container');
    if (container) {
        container.style.opacity = '0';
        container.style.transform = 'translateY(20px)';
        
        setTimeout(() => {
            container.style.transition = 'opacity 0.6s ease, transform 0.6s ease';
            container.style.opacity = '1';
            container.style.transform = 'translateY(0)';
        }, 100);
    }
    
    // Add hover animation to feature boxes
    const featureBoxes = document.querySelectorAll('.feature-box');
    featureBoxes.forEach(box => {
        box.addEventListener('mouseenter', function() {
            this.style.transform = 'translateY(-5px) scale(1.02)';
        });
        
        box.addEventListener('mouseleave', function() {
            this.style.transform = 'translateY(0) scale(1)';
        });
    });
    
    // Form validation
    const forms = document.querySelectorAll('form');
    forms.forEach(form => {
        form.addEventListener('submit', function(e) {
            const inputs = this.querySelectorAll('input[required], select[required]');
            let isValid = true;
            
            inputs.forEach(input => {
                if (!input.value.trim()) {
                    isValid = false;
                    input.style.borderColor = '#ef4444';
                } else {
                    input.style.borderColor = '#10b981';
                }
            });
            
            if (!isValid) {
                e.preventDefault();
                alert('Please fill in all required fields!');
            }
        });
    });
    
    // Add smooth scroll for navigation
    document.querySelectorAll('a[href^="#"]').forEach(anchor => {
        anchor.addEventListener('click', function (e) {
            e.preventDefault();
            const target = document.querySelector(this.getAttribute('href'));
            if (target) {
                target.scrollIntoView({
                    behavior: 'smooth',
                    block: 'start'
                });
            }
        });
    });
    
    // Add typing effect to welcome message (if exists)
    const welcomeElement = document.querySelector('.message');
    if (welcomeElement) {
        const text = welcomeElement.textContent;
        welcomeElement.textContent = '';
        let i = 0;
        
        function typeWriter() {
            if (i < text.length) {
                welcomeElement.textContent += text.charAt(i);
                i++;
                setTimeout(typeWriter, 50);
            }
        }
        
        setTimeout(typeWriter, 500);
    }
});

// Real-time clock (optional)
function updateClock() {
    const clockElement = document.getElementById('live-clock');
    if (clockElement) {
        const now = new Date();
        clockElement.textContent = now.toLocaleTimeString();
    }
}

// Update clock every second if element exists
setInterval(updateClock, 1000);

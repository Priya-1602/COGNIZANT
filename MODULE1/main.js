document.addEventListener('DOMContentLoaded', () => {
    console.log('Welcome to the Community Portal');
    
    // Video handling
    const eventVideo = document.getElementById('eventVideo');
    const videoStatus = document.getElementById('videoStatus');
    if (eventVideo && videoStatus) {
        eventVideo.addEventListener('canplay', () => {
            videoStatus.textContent = 'Video ready to play';
            videoStatus.style.color = '#198754';
        });
        eventVideo.addEventListener('play', () => {
            videoStatus.textContent = 'Video is playing';
            videoStatus.style.color = '#0d6efd';
        });
        eventVideo.addEventListener('pause', () => {
            videoStatus.textContent = 'Video is paused';
            videoStatus.style.color = '#dc3545';
        });
        eventVideo.addEventListener('ended', () => {
            videoStatus.textContent = 'Video has ended';
            videoStatus.style.color = '#6c757d';
        });
    }

    const events = [
        {
            id: 1,
            title: 'Summer Festival',
            date: '2024-07-15',
            time: '10:00 AM - 8:00 PM',
            type: 'festival',
            location: 'Central Park',
            seats: 100,
            price: 'Free',
            description: 'Join us for a day of music, food, and fun activities for the whole family!',
            image: 'https://images.unsplash.com/photo-1533174072545-7a4b6ad7a6c3?w=500&h=300&fit=crop'
        },
        {
            id: 2,
            title: 'Art Workshop',
            date: '2024-06-20',
            time: '2:00 PM - 5:00 PM',
            type: 'workshop',
            location: 'Community Center',
            seats: 20,
            price: '$25',
            description: 'Learn painting techniques from professional artists in this hands-on workshop.',
            image: 'https://images.unsplash.com/photo-1513364776144-60967b0f800f?w=500&h=300&fit=crop'
        },
        {
            id: 3,
            title: 'Sports Day',
            date: '2024-08-05',
            time: '9:00 AM - 4:00 PM',
            type: 'sports',
            location: 'City Stadium',
            seats: 50,
            price: '$15',
            description: 'Annual sports tournament featuring various games and competitions.',
            image: 'https://images.unsplash.com/photo-1461896836934-ffe607ba8211?w=500&h=300&fit=crop'
        }
    ];

    const eventList = document.getElementById('eventList');
    const registrationForm = document.getElementById('registrationForm');
    const contactForm = document.getElementById('contactForm');
    const registrationModal = new bootstrap.Modal(document.getElementById('registrationModal'));
    const eventSearch = document.getElementById('eventSearch');
    const eventFilter = document.getElementById('eventFilter');

    function displayEvents(filteredEvents = events) {
        eventList.innerHTML = filteredEvents.map(event => `
            <div class="col-md-4 mb-4">
                <div class="card event-card h-100">
                    <img src="${event.image}" class="card-img-top" alt="${event.title}">
                    <div class="card-body">
                        <h5 class="card-title">${event.title}</h5>
                        <div class="card-text">
                            <p class="mb-2">
                                <i class="bi bi-calendar-event"></i> ${new Date(event.date).toLocaleDateString()}<br>
                                <i class="bi bi-clock"></i> ${event.time}<br>
                                <i class="bi bi-geo-alt"></i> ${event.location}
                            </p>
                            <p class="mb-2">${event.description}</p>
                            <div class="d-flex justify-content-between align-items-center">
                                <span class="badge bg-primary">${event.price}</span>
                                <span class="badge bg-${event.seats > 10 ? 'success' : 'warning'}">
                                    <i class="bi bi-people"></i> ${event.seats} seats left
                                </span>
                            </div>
                        </div>
                    </div>
                    <div class="card-footer bg-transparent border-top-0">
                        <button class="btn btn-primary w-100" onclick="registerForEvent(${event.id})">
                            <i class="bi bi-ticket-perforated"></i> Register Now
                        </button>
                    </div>
                </div>
            </div>
        `).join('');
    }

    function filterEvents() {
        const searchTerm = eventSearch.value.toLowerCase();
        const filterType = eventFilter.value;
        
        const filteredEvents = events.filter(event => {
            const matchesSearch = event.title.toLowerCase().includes(searchTerm) ||
                                event.description.toLowerCase().includes(searchTerm) ||
                                event.location.toLowerCase().includes(searchTerm);
            const matchesFilter = filterType === 'all' || event.type === filterType;
            return matchesSearch && matchesFilter;
        });
        
        displayEvents(filteredEvents);
    }

    eventSearch.addEventListener('input', filterEvents);
    eventFilter.addEventListener('change', filterEvents);

    window.registerForEvent = (eventId) => {
        const event = events.find(e => e.id === eventId);
        if (event && event.seats > 0) {
            event.seats--;
            displayEvents();
            registrationModal.show();
        } else {
            alert('Sorry, this event is full!');
        }
    };

    registrationForm.addEventListener('submit', (e) => {
        e.preventDefault();
        const formData = new FormData(registrationForm);
        const data = Object.fromEntries(formData.entries());
        
        try {
            if (!data.name || !data.email || !data.eventType || !data.date) {
                throw new Error('Please fill in all required fields');
            }
            
            localStorage.setItem('lastRegistration', JSON.stringify({
                name: data.name,
                eventType: data.eventType,
                date: new Date().toISOString()
            }));
            
            registrationModal.show();
            registrationForm.reset();
        } catch (error) {
            alert(error.message);
        }
    });

    contactForm.addEventListener('submit', (e) => {
        e.preventDefault();
        const formData = new FormData(contactForm);
        const data = Object.fromEntries(formData.entries());
        
        if (!data.contactName || !data.contactEmail || !data.contactMessage) {
            alert('Please fill in all fields');
            return;
        }
        
        alert('Thank you for your message! We will get back to you soon.');
        contactForm.reset();
    });

    const eventTypeSelect = document.getElementById('eventType');
    const savedEventType = localStorage.getItem('lastRegistration');
    if (savedEventType) {
        const { eventType } = JSON.parse(savedEventType);
        eventTypeSelect.value = eventType;
    }

    window.addEventListener('beforeunload', (e) => {
        if (registrationForm.checkValidity()) {
            e.preventDefault();
            e.returnValue = '';
        }
    });

    const messageTextarea = document.getElementById('message');
    messageTextarea.addEventListener('keyup', (e) => {
        const charCount = e.target.value.length;
        if (charCount > 200) {
            e.target.value = e.target.value.substring(0, 200);
        }
    });

    displayEvents();
}); 
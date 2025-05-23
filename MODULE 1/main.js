// Event data
const events = [
    {
        id: 1,
        name: "Community Workshop",
        date: "2024-04-15",
        type: "workshop",
        seats: 20,
        price: 25
    },
    {
        id: 2,
        name: "Summer Concert",
        date: "2024-05-20",
        type: "concert",
        seats: 100,
        price: 50
    },
    {
        id: 3,
        name: "Sports Day",
        date: "2024-06-10",
        type: "sports",
        seats: 50,
        price: 15
    }
];

// DOM Content Loaded
document.addEventListener('DOMContentLoaded', () => {
    console.log('Welcome to the Community Portal');
    loadEvents();
    loadSavedPreferences();
    setupEventListeners();
});

// Load Events
function loadEvents() {
    const container = document.getElementById('eventsContainer');
    container.innerHTML = '';

    events.forEach(event => {
        if (isEventValid(event)) {
            const eventCard = createEventCard(event);
            container.appendChild(eventCard);
        }
    });
}

// Create Event Card
function createEventCard(event) {
    const card = document.createElement('div');
    card.className = 'eventCard';
    card.innerHTML = `
        <h3>${event.name}</h3>
        <p>Date: ${formatDate(event.date)}</p>
        <p>Type: ${event.type}</p>
        <p>Available Seats: ${event.seats}</p>
        <p>Price: $${event.price}</p>
        <button onclick="registerForEvent(${event.id})" class="cta-button">Register</button>
    `;
    return card;
}

// Format Date
function formatDate(dateString) {
    return new Date(dateString).toLocaleDateString('en-US', {
        year: 'numeric',
        month: 'long',
        day: 'numeric'
    });
}

// Check if Event is Valid
function isEventValid(event) {
    const today = new Date();
    const eventDate = new Date(event.date);
    return eventDate >= today && event.seats > 0;
}

// Event Registration Handler
function handleRegistration(event) {
    event.preventDefault();
    
    try {
        const formData = new FormData(event.target);
        const registration = {
            name: formData.get('name'),
            email: formData.get('email'),
            eventType: formData.get('eventType'),
            message: formData.get('message')
        };

        // Save to localStorage
        saveRegistration(registration);

        // Show success message
        const output = document.getElementById('formOutput');
        output.textContent = 'Registration successful!';
        output.style.color = 'green';

        // Reset form
        event.target.reset();

        // Simulate API call
        simulateRegistration(registration);
    } catch (error) {
        console.error('Registration error:', error);
        const output = document.getElementById('formOutput');
        output.textContent = 'Registration failed. Please try again.';
        output.style.color = 'red';
    }

    return false;
}

// Save Registration
function saveRegistration(registration) {
    const registrations = JSON.parse(localStorage.getItem('registrations') || '[]');
    registrations.push(registration);
    localStorage.setItem('registrations', JSON.stringify(registrations));
}

// Simulate Registration API Call
async function simulateRegistration(registration) {
    try {
        const response = await new Promise((resolve) => {
            setTimeout(() => {
                resolve({ success: true, data: registration });
            }, 1000);
        });
        console.log('Registration successful:', response);
    } catch (error) {
        console.error('Registration failed:', error);
    }
}

// Update Event Fee
function updateEventFee() {
    const eventType = document.getElementById('eventType').value;
    const event = events.find(e => e.type === eventType);
    if (event) {
        const output = document.getElementById('formOutput');
        output.textContent = `Event Fee: $${event.price}`;
    }
}

// Enlarge Image
function enlargeImage(img) {
    img.style.transform = img.style.transform === 'scale(1.5)' ? 'scale(1)' : 'scale(1.5)';
}

// Video Ready Handler
function videoReady() {
    const status = document.getElementById('videoStatus');
    status.textContent = 'Video ready to play!';
    status.style.color = 'green';
}

// Find Nearby Events
function findNearbyEvents() {
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(
            position => {
                const { latitude, longitude } = position.coords;
                console.log('Location:', latitude, longitude);
                alert('Finding events near you...');
            },
            error => {
                console.error('Geolocation error:', error);
                alert('Unable to get your location. Please check your permissions.');
            },
            {
                enableHighAccuracy: true,
                timeout: 5000,
                maximumAge: 0
            }
        );
    } else {
        alert('Geolocation is not supported by your browser.');
    }
}

// Clear Preferences
function clearPreferences() {
    localStorage.clear();
    sessionStorage.clear();
    alert('All preferences have been cleared.');
}

// Load Saved Preferences
function loadSavedPreferences() {
    const savedEventType = localStorage.getItem('preferredEventType');
    if (savedEventType) {
        const eventTypeSelect = document.getElementById('eventType');
        eventTypeSelect.value = savedEventType;
    }
}

// Setup Event Listeners
function setupEventListeners() {
    // Form validation
    const forms = document.querySelectorAll('form');
    forms.forEach(form => {
        form.addEventListener('submit', event => {
            if (!form.checkValidity()) {
                event.preventDefault();
                alert('Please fill in all required fields.');
            }
        });
    });

    // Character count for message
    const messageTextarea = document.getElementById('message');
    if (messageTextarea) {
        messageTextarea.addEventListener('keyup', event => {
            const count = event.target.value.length;
            console.log(`Character count: ${count}`);
        });
    }

    // Save event type preference
    const eventTypeSelect = document.getElementById('eventType');
    if (eventTypeSelect) {
        eventTypeSelect.addEventListener('change', event => {
            localStorage.setItem('preferredEventType', event.target.value);
        });
    }
}

// Register for Event
function registerForEvent(eventId) {
    const event = events.find(e => e.id === eventId);
    if (event && event.seats > 0) {
        event.seats--;
        loadEvents();
        alert(`Successfully registered for ${event.name}!`);
    } else {
        alert('Sorry, this event is full or no longer available.');
    }
}

// Before Unload Warning
window.addEventListener('beforeunload', event => {
    const form = document.getElementById('eventForm');
    if (form && form.checkValidity() && form.dataset.modified === 'true') {
        event.preventDefault();
        event.returnValue = '';
    }
}); 
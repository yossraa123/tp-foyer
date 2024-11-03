package tn.esprit.tpfoyer;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.tpfoyer.entity.Etudiant;
import tn.esprit.tpfoyer.entity.Reservation;
import tn.esprit.tpfoyer.repository.EtudiantRepository;

import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

class EtudiantTest {

    @Mock
    EtudiantRepository etudiantRepository;

    @InjectMocks
    Etudiant etudiant;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        etudiant = new Etudiant(1L, "Dupont", "Jean", 12345678L, new Date(), new HashSet<>());
    }

    @Test
    void testEtudiantAttributes() {
        assertEquals(1L, etudiant.getIdEtudiant());
        assertEquals("Dupont", etudiant.getNomEtudiant());
        assertEquals("Jean", etudiant.getPrenomEtudiant());
        assertEquals(12345678L, etudiant.getCinEtudiant());
        assertNotNull(etudiant.getDateNaissance());
        assertTrue(etudiant.getReservations().isEmpty());
    }

    @Test
    void testSaveEtudiant() {
        when(etudiantRepository.save(etudiant)).thenReturn(etudiant);

        Etudiant savedEtudiant = etudiantRepository.save(etudiant);
        assertNotNull(savedEtudiant);
        assertEquals("Dupont", savedEtudiant.getNomEtudiant());
        verify(etudiantRepository, times(1)).save(etudiant);
    }

    @Test
    void testFindEtudiantById() {
        when(etudiantRepository.findById(1L)).thenReturn(Optional.of(etudiant));

        Optional<Etudiant> foundEtudiant = etudiantRepository.findById(1L);
        assertTrue(foundEtudiant.isPresent());
        assertEquals("Jean", foundEtudiant.get().getPrenomEtudiant());
        verify(etudiantRepository, times(1)).findById(1L);
    }

    @Test
    void testAddReservationToEtudiant() {
        Reservation reservation = mock(Reservation.class);
        Set<Reservation> reservations = new HashSet<>();
        reservations.add(reservation);

        etudiant.setReservations(reservations);
        assertFalse(etudiant.getReservations().isEmpty());
        assertEquals(1, etudiant.getReservations().size());
    }
}

package ma.abdex.conferenceservice.RestControllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import ma.abdex.conferenceservice.DTO.ReviewDTO;
import ma.abdex.conferenceservice.Entities.Review;
import ma.abdex.conferenceservice.Services.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@Tag(name = "Review Management", description = "APIs for managing conference reviews")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
    @Operation(summary = "Create a new review")
    public ResponseEntity<Review> saveReview(@RequestBody ReviewDTO reviewDTO) {
        return ResponseEntity.ok(reviewService.save(reviewDTO));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get review by ID")
    public ResponseEntity<ReviewDTO> getReviewById(@PathVariable Long id) {
        return ResponseEntity.ok(reviewService.getReviewById(id));
    }

    @GetMapping
    @Operation(summary = "Get all reviews")
    public ResponseEntity<List<ReviewDTO>> getReviews() {
        return ResponseEntity.ok(reviewService.getReviews());
    }

    @GetMapping("/conference/{conferenceId}")
    @Operation(summary = "Get reviews by conference ID")
    public ResponseEntity<List<ReviewDTO>> getReviewsByConferenceId(@PathVariable Long conferenceId) {
        return ResponseEntity.ok(reviewService.getReviewsByConferenceId(conferenceId));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete review by ID")
    public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update review by ID")
    public ResponseEntity<Review> updateReview(@PathVariable Long id, @RequestBody ReviewDTO reviewDTO) {
        return ResponseEntity.ok(reviewService.updateReview(id, reviewDTO));
    }
}


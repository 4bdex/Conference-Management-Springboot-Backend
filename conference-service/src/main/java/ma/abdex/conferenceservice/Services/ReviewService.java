package ma.abdex.conferenceservice.Services;

import ma.abdex.conferenceservice.DAO.ConferenceDAO;
import ma.abdex.conferenceservice.DAO.ReviewDAO;
import ma.abdex.conferenceservice.DTO.ReviewDTO;
import ma.abdex.conferenceservice.Entities.Review;
import ma.abdex.conferenceservice.Mapper.ReviewMapper;
import ma.abdex.conferenceservice.Repositories.ReviewRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ReviewService {
    private final ReviewMapper reviewMapper;
    private final ConferenceDAO conferenceDAO;
    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewMapper reviewMapper, ConferenceDAO conferenceDAO, ReviewRepository reviewRepository) {
        this.reviewMapper = reviewMapper;
        this.conferenceDAO = conferenceDAO;
        this.reviewRepository = reviewRepository;
    }

    public Review save(ReviewDTO reviewDTO) {
        return reviewRepository.save(reviewMapper.toEntity(reviewDTO, conferenceDAO));
    }

    public ReviewDTO getReviewById(Long id) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found with id: " + id));
        return reviewMapper.toDto(review);
    }

    public List<ReviewDTO> getReviews() {
        List<Review> reviews = reviewRepository.findAll();
        return reviewMapper.toDtoList(reviews);
    }

    public List<ReviewDTO> getReviewsByConferenceId(Long conferenceId) {
        List<Review> reviews = reviewRepository.findByConferenceId(conferenceId);
        return reviewMapper.toDtoList(reviews);
    }

    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }

    public Review updateReview(Long id, ReviewDTO reviewDTO) {
        Review existingReview = reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found with id: " + id));

        existingReview.setDate(reviewDTO.getDate());
        existingReview.setText(reviewDTO.getText());
        existingReview.setStars(reviewDTO.getStars());

        return reviewRepository.save(existingReview);
    }
}


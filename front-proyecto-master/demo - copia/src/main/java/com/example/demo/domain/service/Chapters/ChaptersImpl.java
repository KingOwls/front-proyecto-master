package com.example.demo.domain.service.Chapters;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.repositories.ChapterRepository;
import com.example.demo.repository.entities.ChaptersEntity;

import jakarta.transaction.Transactional;

@Service
public class ChaptersImpl implements ChaptersService {

    @Autowired
    private ChapterRepository repository;

   

    @Transactional
    @Override
    public List<ChaptersEntity> findAll() {
        return (List<ChaptersEntity>) repository.findAll();
    }

    @Transactional
    @Override
    public Optional<ChaptersEntity> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public ChaptersEntity save(ChaptersEntity chapter) {
        return repository.save(chapter);
    }

    @Transactional
    @Override
    public Optional<ChaptersEntity> update(Long id, ChaptersEntity chapter) {
        Optional<ChaptersEntity> chapterOpt = repository.findById(id);

        if (chapterOpt.isPresent()) {
            ChaptersEntity existingChapter = chapterOpt.orElseThrow();
            existingChapter.setChapterNumber(chapter.getChapterNumber());
            existingChapter.setChapterTitle(chapter.getChapterTitle());
            return Optional.of(repository.save(existingChapter));
        }

        return chapterOpt;
    }

    @Transactional
    @Override
    public Optional<ChaptersEntity> delete(Long id) {
        Optional<ChaptersEntity> chapterOpt = repository.findById(id);
        chapterOpt.ifPresent(chapterItem ->{
            repository.delete(chapterItem);
        });
        return chapterOpt;
    }
}

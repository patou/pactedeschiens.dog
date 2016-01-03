package com.geminicode.pactedeschiens.servlet;


import com.geminicode.pactedeschiens.service.ArticleService;
import com.geminicode.pactedeschiens.utils.ServiceFactory;
import com.google.appengine.api.blobstore.*;
import com.google.appengine.api.images.ImagesService;
import com.google.appengine.api.images.ImagesServiceFactory;
import com.google.appengine.api.images.ServingUrlOptions;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class UploadServlet extends HttpServlet {

    private final Logger logger = Logger.getLogger(UploadServlet.class.getName());

    private final BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();

    private final ArticleService articleService = ServiceFactory.get().getArticleService();

    private final ImagesService imagesService = ImagesServiceFactory.getImagesService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        final PrintWriter writer = res.getWriter();
        res.setHeader("Content-Type", "text/html");
        logger.info("upload servlet");
        try {
            final Map<String, List<BlobKey>> blobs = blobstoreService.getUploads(req);
            List<BlobKey> blobKey = blobs.get("file");
            for (String file : blobs.keySet()) {
                logger.info("get blob " + file);
                blobKey = blobs.get(file);

                if (blobKey != null && !blobKey.isEmpty()) {
                    break;
                }
            }
            if (blobKey == null || blobKey.isEmpty()) {
                writer.println("Pas de fichier");
            } else {
                final BlobKey key = blobKey.get(0);
                final String imageUrl =
                        imagesService.getServingUrl(ServingUrlOptions.Builder.withBlobKey(key).imageSize(30)
                                .crop(true));

                final String id = req.getParameter("id");

                final BlobInfoFactory infoFactory = new BlobInfoFactory();
                final BlobInfo info = infoFactory.loadBlobInfo(key);
                final String filename = info.getFilename();
                logger.info("filename " + filename);
                articleService.updateCover(Long.valueOf(id), imageUrl);

            }
        } catch (Exception e) {
            logger.severe(e.getLocalizedMessage());
        }
    }
}
